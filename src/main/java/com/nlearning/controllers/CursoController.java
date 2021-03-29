package com.nlearning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nlearning.models.Curso;
import com.nlearning.repository.CursoRepository;

@Controller
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	// Rota para o get do form
	@RequestMapping(value = "/cadastrarCurso", method = RequestMethod.GET)
	public String form() {

		return "curso/form_curso";

	}

	// Cadastra os dados do aluno no banco de dados
	@RequestMapping(value = "/cadastrarCurso", method = RequestMethod.POST)
	public String form(Curso curso) {
			cursoRepository.save(curso);
			return "redirect:cadastrarCurso";
		}
	}
