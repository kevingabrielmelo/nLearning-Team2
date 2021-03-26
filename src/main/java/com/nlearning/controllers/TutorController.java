package com.nlearning.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.models.Tutor;
import com.nlearning.models.Usuario;
import com.nlearning.repository.TutorRepository;

@Controller
public class TutorController {

	@Autowired
	private TutorRepository tutorRepository;

	// Validação de login
	@RequestMapping(value = "/cadastrarTutor", method = RequestMethod.GET)
	public String form(HttpSession sessao) {
		if (Usuario.tipoUsu == "admin" || Usuario.tipoUsu == "gestor") {
			return "tutor/form_tutor";
		} else {
			return "redirect:login";
		}
	}

	// Validação de login (MENU)
	@RequestMapping(value = "/menuTutor")
	public String checkMenu(HttpSession sessao) {
		if (Usuario.tipoUsu == "tutor") {
			return "tutor/menu_tutor";
		} else {
			return "redirect:login";
		}
	}

	// Validação de login (UPDATE)
	@RequestMapping(value = "/update_tutor")
	public String checkUpdate() {
		if (Usuario.tipoUsu == "aluno") {
			return "redirect:login";
		} else {
			return "redirect:alterarDadosTutor";
		}
	}

	// Encontra os dados do admin alvo
	@RequestMapping(value = "alterarDadosTutor", method = RequestMethod.GET)
	public ModelAndView dadosAdmin(Long idAdmin) {
		Tutor tutor = tutorRepository.findByIdTutor(Usuario.idUsu);
		ModelAndView mv = new ModelAndView("tutor/update_tutor");
		mv.addObject("tutor", tutor);

		return mv;
	}

	// Salva os dados do admin alvo e atualiza no banco
	@RequestMapping(value = "alterarDadosTutor", method = RequestMethod.POST)
	public String form_update(Tutor tutor, Long idTutor) {
		tutor.setIdTutor(Usuario.idUsu);
		tutorRepository.save(tutor);
		return "redirect:alterarDadosTutor";
	}

	@RequestMapping(value = "/cadastrarTutor", method = RequestMethod.POST)
	public String form(Tutor tutor) {
		tutorRepository.save(tutor);
		return "redirect:cadastrarTutor";
	}
}