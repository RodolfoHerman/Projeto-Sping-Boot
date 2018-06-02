package br.com.rodolfo.lista.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodolfo.lista.model.Convidado;
import br.com.rodolfo.lista.repository.ConvidadoRepository;

/**
 * ConvidadoService
 */
//O Controller da convidados não pode acessar a base de dados diretamente, isso é feito pela camada de serviços
@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository repository;

    public Iterable<Convidado> buscarTodos() {
        return repository.findAll();
    }

    public void salvar(Convidado convidado) {
        repository.save(convidado);
    }

}