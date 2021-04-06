package com.nlearning.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "redirect:cadastrarCurso";
	}

	@GetMapping(value = "/cursos")
	public ModelAndView listaCursos() throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("/curso/lista_cursos");
		Iterable<Curso> curso = cursoRepository.findAll();
		List<Curso> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();

		for (Curso cursos : curso) {
			String imagem = Base64.getEncoder().encodeToString(cursos.getImagem());
			list.add(cursos);
			list2.add(imagem);
		}
		
		mv.addObject("imagem", list2);
		mv.addObject("curso", list);

		return mv;
	}

	@GetMapping(value = "/cursos/{id_curso}")
	public ModelAndView listCursos(@PathVariable("id_curso") Long id_curso) {
		Curso curso = cursoRepository.findByIdCurso(id_curso);
		ModelAndView mv = new ModelAndView("/curso/lista_cursos");
		mv.addObject("curso", curso);

		String imagem = Base64.getEncoder().encodeToString(curso.getImagem());
		mv.addObject("imagem", imagem);

		return mv;
	}
}