package gerenciamentoTarefas.controller;

import gerenciamentoTarefas.domain.Tarefa;
import gerenciamentoTarefas.dto.TarefaDTO;
import gerenciamentoTarefas.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> adicionarTarefas(@RequestBody TarefaDTO tarefaDTO) {
        return ResponseEntity.ok().body(tarefaService.adicionarTarefa(tarefaDTO));
    }

    @RequestMapping(value = "alocar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> alocarPessoaTarefa(@PathVariable ("id") Integer id) throws Exception {
        return ResponseEntity.ok(tarefaService.alocarPessoaTarefa(id));
    }

    @RequestMapping(value = "finalizar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> finalizarTarefa(@PathVariable ("id") Integer id, @RequestBody TarefaDTO tarefaDTO) throws Exception {
        return ResponseEntity.ok().body(tarefaService.finalizarTarefa(id, tarefaDTO));
    }

    @RequestMapping(value = "/pendentes", method = RequestMethod.GET)
    public ResponseEntity<List<TarefaDTO>> listaTarefasExistentes() {
        return ResponseEntity.ok(tarefaService.listaTarefasExistentes());
    }
}
