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

import br.ufscar.dc.dsw.domain.Empresa;
import br.ufscar.dc.dsw.service.spec.IEmpresaService;
import jakarta.validation.Valid;

@RestController
public class EmpresaRestController {

    @Autowired
    private IEmpresaService service;

    // Listar todas as empresas
    @GetMapping(path = "/api/empresas")
    public ResponseEntity<List<Empresa>> lista() {
        List<Empresa> lista = service.buscarTodos();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Retorna 204 se não houver empresas
        }
        return ResponseEntity.ok(lista);
    }

    // Buscar uma empresa por ID
    @GetMapping(path = "/api/empresas/{id}")
    public ResponseEntity<Empresa> lista(@PathVariable("id") long id) {
        Empresa empresa = service.buscarPorId(id);
        if (empresa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Retorna 404 se a empresa não for encontrada
        }
        return ResponseEntity.ok(empresa);
    }

    // Criar uma nova empresa
    @PostMapping(path = "/api/empresas")
    @ResponseBody
    public ResponseEntity<?> cria(@Valid @RequestBody Empresa empresa, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(getValidationErrors(result), HttpStatus.BAD_REQUEST);  // Valida e retorna erros
        } else {
            service.salvar(empresa);
            return new ResponseEntity<>(empresa, HttpStatus.CREATED);  // Retorna 201 Created
        }
    }

    // Atualizar uma empresa existente
    @PutMapping(path = "/api/empresas/{id}")
    public ResponseEntity<?> atualiza(@PathVariable("id") long id, @Valid @RequestBody Empresa empresa, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(getValidationErrors(result), HttpStatus.BAD_REQUEST);  // Valida e retorna erros
        } else {
            Empresa existente = service.buscarPorId(id);
            if (existente == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Retorna 404 se a empresa não for encontrada
            } else {
                empresa.setId(id);
                service.salvar(empresa);
                return ResponseEntity.ok(empresa);  // Retorna 200 OK
            }
        }
    }

    // Excluir uma empresa
    @DeleteMapping(path = "/api/empresas/{id}")
    public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {
        Empresa empresa = service.buscarPorId(id);
        if (empresa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Retorna 404 se a empresa não for encontrada
        } else {
            if (service.empresaTemVagas(id)) {  // Verifica se a empresa tem filmes associados
                return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);  // Retorna 403 se não puder ser excluída
            } else {
                service.excluir(id);
                return new ResponseEntity<>(true, HttpStatus.OK);  // Retorna 200 OK se excluída com sucesso
            }
        }
    }

    // Método auxiliar para capturar erros de validação e retornar para o cliente
    private List<String> getValidationErrors(BindingResult result) {
        return result.getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
    }
}
