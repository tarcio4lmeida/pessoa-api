package com.orangetalents.pessoaapi.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.orangetalents.pessoaapi.entity.Pessoa;

public class PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@NotBlank(message = "{campo.email.obrigatorio}")
	private String email;
	
	@NotBlank(message = "{campo.cpf.obrigatorio}")
	@CPF(message = "{campo.cpf.invalido}")
	private String cpf;
	
	@NotNull(message = "{campo.dataNascimento.obrigatorio}")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate  dataNascimento;
	
	public PessoaDTO() {
	}

	public PessoaDTO(Long id, String nome, String email, 
				String cpf, LocalDate  dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public PessoaDTO(Pessoa p) {
		this.id = p.getId();
		this.nome = p.getNome();
		this.email = p.getEmail();
		this.cpf = p.getCpf();
		this.dataNascimento = p.getDataNascimento();
	}
	// Getters e Setters Omissos

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
}
