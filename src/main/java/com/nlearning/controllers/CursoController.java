package com.nlearning.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.models.Curso;
import com.nlearning.models.CursoControllerModel;
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

	// Cadastra os dados do curso no banco de dados
	@RequestMapping(value = "/cadastrarCurso", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String form(@RequestParam(value = "imagem") MultipartFile imagem, CursoControllerModel curso)
			throws IOException {
		cursoRepository.save(CursoMapper.converter(curso, imagem));
		return "redirect:cursos";
	}

	@GetMapping(value = "/cursos")
	public ModelAndView listaCursos() throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("/curso/lista_cursos");
		Iterable<Curso> curso = cursoRepository.findAll();
		List<Curso> lista_cursos = new ArrayList<>();

		for (Curso cursos : curso) {
			String imagem = Base64.getEncoder().encodeToString(cursos.getImagem());
			cursos.setImagem_string(imagem);
			lista_cursos.add(cursos);
		}

		mv.addObject("curso", lista_cursos);

		return mv;
	}

	@RequestMapping(value = "/selectCurso")
	public ModelAndView telaCurso(@RequestParam("idCurso") Long idCurso) {
		Curso curso = cursoRepository.findByIdCurso(idCurso);
		ModelAndView mv = new ModelAndView("/curso/update_curso");
		String imagem = Base64.getEncoder().encodeToString(curso.getImagem());
		curso.setImagem_string(imagem);
		mv.addObject("curso", curso);
		return mv;
	}

	@RequestMapping(value = "selectCurso", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String form_update(@RequestParam("idCurso") Long idCurso,
			@RequestParam(value = "imagem") MultipartFile imagem, CursoControllerModel curso) throws IOException {
		Curso cursoUpdate = CursoMapper.converter(curso, imagem);
		cursoUpdate.setIdCurso(idCurso);
		cursoRepository.save(cursoUpdate);
		return "redirect:/cursos";
	}

	@RequestMapping("/deletar/{id_curso}")
	public String deletarCurso(Long idCurso) {
		Curso curso = cursoRepository.findByIdCurso(idCurso);
		cursoRepository.delete(curso);
		return "redirect:/cursos";
	}
}
