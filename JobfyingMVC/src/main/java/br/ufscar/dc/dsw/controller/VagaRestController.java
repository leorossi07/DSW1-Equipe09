package br.ufscar.dc.dsw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufscar.dc.dsw.domain.Vaga;
import br.ufscar.dc.dsw.service.spec.IVagaService;
import jakarta.validation.Valid;

@RestController
public class VagaRestController {

	@Autowired
	private IVagaService service;

	@GetMapping(path = "/api/vagas")
	public ResponseEntity<List<Vaga>> lista() {
		List<Vaga> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Mudança para indicar que a lista está vazia
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping(path = "/api/vagas/{id}")
	public ResponseEntity<Vaga> lista(@PathVariable("id") long id) {
		Vaga vaga = service.buscarPorId(id);
		if (vaga == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorno claro de erro
		}
		return ResponseEntity.ok(vaga);
	}

	@PostMapping(path = "/api/vagas")
	@ResponseBody
	public ResponseEntity<?> cria(@Valid @RequestBody Vaga vaga, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(getValidationErrors(result), HttpStatus.BAD_REQUEST); // Retorna erros de validação
		} else {
			service.salvar(vaga);
			return new ResponseEntity<>(vaga, HttpStatus.CREATED); // Resposta adequada para criação
		}
	}

	@PutMapping(path = "/api/vagas/{id}")
	public ResponseEntity<?> atualiza(@PathVariable("id") long id, @Valid @RequestBody Vaga vaga, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(getValidationErrors(result), HttpStatus.BAD_REQUEST); // Validação para atualização
		} else {
			Vaga existente = service.buscarPorId(id);
			if (existente == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Caso não encontrado
			} else {
				vaga.setId(id);
				service.salvar(vaga);
				return ResponseEntity.ok(vaga); // Retorno padrão para atualização
			}
		}
	}

	@DeleteMapping(path = "/api/vagas/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {
		Vaga vaga = service.buscarPorId(id);
		if (vaga == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			service.excluir(id);
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
	}

	// Método auxiliar para capturar erros de validação e retornar para o cliente
	private List<String> getValidationErrors(BindingResult result) {
		return result.getFieldErrors().stream()
				.map(error -> error.getField() + ": " + error.getDefaultMessage())
				.toList();
	}
}
