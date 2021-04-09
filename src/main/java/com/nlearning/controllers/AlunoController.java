package com.nlearning.controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.models.Aluno;
import com.nlearning.models.Curso;
import com.nlearning.models.Usuario;
import com.nlearning.repository.AlunoRepository;
import com.nlearning.repository.CursoRepository;

@Controller
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	// Validação de login (CADASTRAR)
	@RequestMapping(value = "/cadastrarAluno")
	public String checkForm(HttpSession sessao) {
		if (Usuario.tipoUsu == "admin" || Usuario.tipoUsu == "gestor") {
			return "aluno/form_aluno";
		} else {
			return "redirect:login";
		}
	}

	// Cadastra os dados do aluno no banco de dados
	@RequestMapping(value = "/cadastrarAluno", method = RequestMethod.POST)
	public String form(Aluno aluno, String senhaConfirmacao) {
		if (aluno.getSenha().equals(senhaConfirmacao)) {
			alunoRepository.save(aluno);
			return "redirect:login";
		} else {
			return "redirect:cadastrarAluno";
		}
	}

	// Validação de login (MENU)
	@RequestMapping(value = "/menuAluno")
	public String checkMenu(HttpSession sessao) {
		if (Usuario.tipoUsu == "aluno") {
			return "aluno/menu_aluno";
		} else {
			return "redirect:login";
		}
	}

	// Validação de login (UPDATE)
	@RequestMapping(value = "/update_aluno")
	public String checkUpdate() {
		if (Usuario.tipoUsu == "tutor") {
			return "redirect:login";
		} else {
			return "redirect:alterarDadosAluno";
		}
	}

	// Encontra os dados do aluno alvo
	@RequestMapping(value = "alterarDadosAluno", method = RequestMethod.GET)
	public ModelAndView dadosAluno(Long idAluno) {
		Aluno aluno = alunoRepository.findByIdAluno(Usuario.idUsu);
		ModelAndView mv = new ModelAndView("aluno/update_aluno");
		mv.addObject("aluno", aluno);

		return mv;
	}

	// Salva os dados do aluno alvo e atualiza no banco
	@RequestMapping(value = "alterarDadosAluno", method = RequestMethod.POST)
	public String form_update(Aluno aluno, Long idAluno) {
		aluno.setIdAluno(Usuario.idUsu);
		alunoRepository.save(aluno);
		return "redirect:alterarDadosAluno";
	}

	@RequestMapping("/deletar/{id_aluno}")
	public String deletarAluno(Long idAluno) {
		Aluno aluno = alunoRepository.findByIdAluno(idAluno);
		alunoRepository.delete(aluno);
		return "redirect:/usuarios";
	}

	@GetMapping(value = "/cursosnLearning")
	public ModelAndView listaCursos() throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("/curso/lista_cursos_aluno");
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

	@RequestMapping(value = "/comprarCurso")
	public ModelAndView telaCurso(@RequestParam("idCurso") Long idCurso) {
		Curso curso = cursoRepository.findByIdCurso(idCurso);
		ModelAndView mv = new ModelAndView("/curso/comprar_curso");
		String imagem = Base64.getEncoder().encodeToString(curso.getImagem());
		curso.setImagem_string(imagem);
		mv.addObject("curso", curso);
		return mv;
	}
}