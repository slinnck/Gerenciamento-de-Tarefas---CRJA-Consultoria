package gerenciamentoTarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gerenciamentoTarefas.dto.PessoaDTO;
import gerenciamentoTarefas.services.PessoaService;

@RestController
@RequestMapping(value= "/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> cadastrarPessoa(@RequestBody PessoaDTO pessoaDTO) {
		return ResponseEntity.ok().body(pessoaService.cadastrarPessoa(pessoaDTO));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> editarPessoa(@PathVariable Integer id, @RequestBody PessoaDTO pessoaDTO) {
		return ResponseEntity.ok().body(pessoaService.editarPessoa(id, pessoaDTO));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletarPessoa(@PathVariable Integer id) {
		return ResponseEntity.ok(pessoaService.deletarPessoa(id));
	}
	

}
