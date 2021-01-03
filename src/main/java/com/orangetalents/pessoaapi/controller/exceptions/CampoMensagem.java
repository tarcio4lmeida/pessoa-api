package com.orangetalents.pessoaapi.controller.exceptions;

import java.io.Serializable;

public class CampoMensagem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nomeCampo;
	private String mensagem;
	
	
	public CampoMensagem() {
	}
	public CampoMensagem(String nomeCampo, String mensagem) {
		this.nomeCampo = nomeCampo;
		this.mensagem = mensagem;
	}
	public String getNomeCampo() {
		return nomeCampo;
	}
	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
