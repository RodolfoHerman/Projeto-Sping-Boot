package br.com.rodolfo.lista.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Convidado
 */
@Entity(name="convidado")
public class Convidado {

    private Long  id;
    private String nome;
    private String email;
    private String telefone;

	public Convidado(){}
	
	public Convidado(String nome, String email, String telefone) {
		this.nome = nome;
		this.email =  email;
		this.telefone = telefone;
	}

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return this.nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getTelefone()
	{
		return this.telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}


    




}