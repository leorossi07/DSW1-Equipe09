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

import br.ufscar.dc.dsw.domain.Candidatura;
import br.ufscar.dc.dsw.service.spec.ICandidaturaService;
import jakarta.validation.Valid;

@RestController
public class CandidaturaRestController {

	@Autowired
	private ICandidaturaService service;

	@GetMapping(path = "/api/candidaturas")
	public ResponseEntity<List<Candidatura>> lista() {
		List<Candidatura> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Mudança para indicar que a lista está vazia
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping(path = "/api/candidaturas/{id}")
	public ResponseEntity<Candidatura> lista(@PathVariable("id") long id) {
		Candidatura candidatura = service.buscarPorId(id);
		if (candidatura == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorno claro de erro
		}
		return ResponseEntity.ok(candidatura);
	}

	@PostMapping(path = "/api/candidaturas")
	@ResponseBody
	public ResponseEntity<?> cria(@Valid @RequestBody Candidatura candidatura, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(getValidationErrors(result), HttpStatus.BAD_REQUEST); // Retorna erros de validação
		} else {
			service.salvar(candidatura);
			return new ResponseEntity<>(candidatura, HttpStatus.CREATED); // Resposta adequada para criação
		}
	}

	@PutMapping(path = "/api/candidaturas/{id}")
	public ResponseEntity<?> atualiza(@PathVariable("id") long id, @Valid @RequestBody Candidatura candidatura, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(getValidationErrors(result), HttpStatus.BAD_REQUEST); // Validação para atualização
		} else {
			Candidatura existente = service.buscarPorId(id);
			if (existente == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Caso não encontrado
			} else {
				candidatura.setId(id);
				service.salvar(candidatura);
				return ResponseEntity.ok(candidatura); // Retorno padrão para atualização
			}
		}
	}

	@DeleteMapping(path = "/api/candidaturas/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {
		Candidatura candidatura = service.buscarPorId(id);
		if (candidatura == null) {
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
