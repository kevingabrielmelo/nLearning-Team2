package com.nlearning.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.models.Aluno;
import com.nlearning.models.Usuario;
import com.nlearning.repository.AlunoRepository;

@Controller
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	// Validação de login (CADASTRAR)
	@RequestMapping(value = "/cadastrarAluno")
	public String checkForm(HttpSession sessao) {
		if (Usuario.tipoUsu == "admin" || Usuario.tipoUsu == "gestor") {
			return "aluno/form_aluno";
		} else {
			return "redirect:login";
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

	//Validação de login (UPDATE)
	@RequestMapping(value = "/update_aluno")
    public String checkUpdate() {
	if (Usuario.tipoUsu == "tutor") {
		return "redirect:login";
	} else {
		return "redirect:Alterar_Dados_Aluno";
	}
}
	
	//Encontra os dados do aluno alvo
	@RequestMapping(value = "Alterar_Dados_Aluno", method = RequestMethod.GET)
	public ModelAndView dadosAluno(Long idAluno) {
		idAluno = Usuario.idUsu;
		Aluno aluno = alunoRepository.findByIdAluno(idAluno);
		ModelAndView mv = new ModelAndView("aluno/update_aluno");
		mv.addObject("aluno", aluno);

		return mv;
	}

	// Cadastra os dados do aluno no banco de dados
	@RequestMapping(value = "/cadastrarAluno", method = RequestMethod.POST)
	public String form(Aluno aluno) {
		alunoRepository.save(aluno);
		return "redirect:cadastrarAluno";
	}

	// Salva os dados do aluno alvo e atualiza no banco
	@RequestMapping(value = "Alterar_Dados_Aluno", method = RequestMethod.POST)
	public String form_update(Aluno aluno, Long idAluno) {
		alunoRepository.findByIdAluno(idAluno);
		alunoRepository.save(aluno);
		return "redirect:Alterar_Dados_Aluno";
	}
}