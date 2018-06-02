package br.com.rodolfo.lista.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.rodolfo.lista.model.Convidado;

/**
 * ConvidadoRepository
 */
//O JPA implementa o CRUD para nós através do 'CrudRepository' onde é necessário passar a CLASSE e o SERIALIZE dela como argumentos para o GENERIC  
public interface ConvidadoRepository extends CrudRepository<Convidado, Long>{

    List<Convidado> findByNome(String nome);
}