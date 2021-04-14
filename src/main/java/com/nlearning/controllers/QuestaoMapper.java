package com.nlearning.controllers;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.nlearning.models.Questao;

public class QuestaoMapper {

	public static Questao converter(MultipartFile pergunta, Long idCurso) throws IOException {

		var questoes = new Questao();
		
		questoes.setPergunta(pergunta.getBytes());
		questoes.setIdCurso(idCurso);

		return questoes;
	}
}
