package gerenciamentoTarefas.controller;

import gerenciamentoTarefas.dto.DepartamentoDTO;
import gerenciamentoTarefas.services.DepartamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentosController {

    @Autowired
    DepartamentosService departamentosService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DepartamentoDTO>> buscarDepartamentos(){
        return ResponseEntity.ok(departamentosService.buscarDepartamentos());
    }
}
