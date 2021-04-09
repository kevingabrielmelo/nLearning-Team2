package com.nlearning.models;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class CursoControllerModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idCurso;
	private String nomeCurso;
	private String descricao;
	private Double valor;
	private String tutor;
	private MultipartFile imagem;

	public CursoControllerModel() {}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public MultipartFile getImagem() {
		return imagem;
	}

	public void setImagem(MultipartFile imagem) {
		this.imagem = imagem;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}
}
