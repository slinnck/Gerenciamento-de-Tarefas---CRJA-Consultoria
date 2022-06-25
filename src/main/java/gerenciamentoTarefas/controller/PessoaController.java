package gerenciamentoTarefas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/pessoa")
public class PessoaController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String gerenciarPessoa() {
		return "Está funcionando";
	}

}
