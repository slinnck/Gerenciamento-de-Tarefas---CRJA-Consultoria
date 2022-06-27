package gerenciamentoTarefas.services.impl;

import gerenciamentoTarefas.domain.enums.RegistroDeDepartamento;
import gerenciamentoTarefas.dto.DepartamentoDTO;
import gerenciamentoTarefas.repository.PessoaRepository;
import gerenciamentoTarefas.repository.TarefaRepository;
import gerenciamentoTarefas.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartamentosServiceImpl implements DepartamentoService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    TarefaRepository tarefaRepository;

    @Override
    public List<DepartamentoDTO> buscarDepartamentos(){
        List<DepartamentoDTO> listaDepartamentos = new ArrayList<>();

        DepartamentoDTO financeiro = new DepartamentoDTO();
        DepartamentoDTO comercial = new DepartamentoDTO();
        DepartamentoDTO desenvolvimento = new DepartamentoDTO();

        financeiro.setQtdTarefas(tarefaRepository.buscarTarefasPorDepartamento(RegistroDeDepartamento.FINANCEIRO.getCod()));
        comercial.setQtdTarefas(tarefaRepository.buscarTarefasPorDepartamento(RegistroDeDepartamento.COMERCIAL.getCod()));
        desenvolvimento.setQtdPessoas(pessoaRepository.buscarPessoasPorDepartamento(RegistroDeDepartamento.DESENVOLVIMENTO.getCod()));

        financeiro.setDepartamento(RegistroDeDepartamento.FINANCEIRO.getDescricao());
        comercial.setQtdPessoas(pessoaRepository.buscarPessoasPorDepartamento(RegistroDeDepartamento.COMERCIAL.getCod()));
        desenvolvimento.setQtdTarefas(tarefaRepository.buscarTarefasPorDepartamento(RegistroDeDepartamento.DESENVOLVIMENTO.getCod()));

        financeiro.setQtdPessoas(pessoaRepository.buscarPessoasPorDepartamento(RegistroDeDepartamento.FINANCEIRO.getCod()));
        comercial.setDepartamento(RegistroDeDepartamento.COMERCIAL.getDescricao());
        desenvolvimento.setDepartamento(RegistroDeDepartamento.DESENVOLVIMENTO.getDescricao());

        listaDepartamentos.addAll(Arrays.asList(financeiro,comercial, desenvolvimento));
        return listaDepartamentos;
    }
}
