package gerenciamentoTarefas.controller;

import gerenciamentoTarefas.dto.DepartamentoDTO;
import gerenciamentoTarefas.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class DepartamentosController {

    @Autowired
    DepartamentoService departamentoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DepartamentoDTO>> buscarDepartamentos(){
        return ResponseEntity.ok(departamentoService.buscarDepartamentos());
    }
}
