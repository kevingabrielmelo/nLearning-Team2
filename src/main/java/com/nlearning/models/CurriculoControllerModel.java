package com.nlearning.models;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class CurriculoControllerModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String telefone;
	private String email;
	private MultipartFile curriculo;

	public CurriculoControllerModel() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MultipartFile getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(MultipartFile curriculo) {
		this.curriculo = curriculo;
	}
}
