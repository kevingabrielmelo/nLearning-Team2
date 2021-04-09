package com.nlearning.controllers;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.nlearning.models.Curso;
import com.nlearning.models.CursoControllerModel;

public class CursoMapper {

	public static Curso converter(CursoControllerModel curso, MultipartFile imagem) throws IOException {
		
		var cursoBanco = new Curso();
		cursoBanco.setIdCurso(curso.getIdCurso());
		cursoBanco.setNomeCurso(curso.getNomeCurso());
		cursoBanco.setDescricao(curso.getDescricao());
		cursoBanco.setTutor(curso.getTutor());
		cursoBanco.setValor(curso.getValor());
		cursoBanco.setImagem(imagem.getBytes());
		
		return cursoBanco;
	}
}
