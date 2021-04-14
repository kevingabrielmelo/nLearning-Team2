package com.nlearning.models;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class QuestaoControllerModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private long idQuestao;
	
	private MultipartFile pergunta;
	private long idCurso;
	
	public long getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(long idQuestao) {
		this.idQuestao = idQuestao;
	}
	public MultipartFile getPergunta() {
		return pergunta;
	}
	public void setPergunta(MultipartFile pergunta) {
		this.pergunta = pergunta;
	}
	public long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}
}
