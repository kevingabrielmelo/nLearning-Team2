package com.nlearning.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AvaliacaoCompetenciaAluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAval;
	
	private long idAluno;
	private long idTutor;
	private String Titulo;
	private String AvaliacaoCompt;
	private String AvaliacaoTecnica;
	
	public long getIdAval() {
		return idAval;
	}
	public void setIdAval(long idAval) {
		this.idAval = idAval;
	}
	public long getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}
	public long getIdTutor() {
		return idTutor;
	}
	public void setIdTutor(long idTutor) {
		this.idTutor = idTutor;
	}
	public String getAvaliacaoCompt() {
		return AvaliacaoCompt;
	}
	public void setAvaliacaoCompt(String avaliacaoCompt) {
		AvaliacaoCompt = avaliacaoCompt;
	}
	public String getAvaliacaoTecnica() {
		return AvaliacaoTecnica;
	}
	public void setAvaliacaoTecnica(String avaliacaoTecnica) {
		AvaliacaoTecnica = avaliacaoTecnica;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

}
