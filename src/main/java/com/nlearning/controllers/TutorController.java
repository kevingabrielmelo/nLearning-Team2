package com.nlearning.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

	//Vo mexe n pq esse ta funfando
	@RequestMapping(value = "/tutor/{idTutor}", method = RequestMethod.GET)
	public String tutor(HttpSession sessao) {
		if (Usuario.tipoUsu == "admin" || Usuario.tipoUsu == "gestor") {
			return "tutor/update_tutor";
		} else {
			return "redirect:login";
		}
	}
	public ModelAndView detalhesEvento(@PathVariable("idTutor") Long idTutor) {
		Tutor tutor = tutorRepository.findByIdTutor(idTutor);
		ModelAndView mv = new ModelAndView("tutor/update_tutor");
		mv.addObject("tutor", tutor);

		return mv;
	}

	@RequestMapping(value = "/cadastrarTutor", method = RequestMethod.POST)
	public String form(Tutor tutor) {
		tutorRepository.save(tutor);
		return "redirect:cadastrarTutor";
	}
	
	@RequestMapping(value = "/tutor/{idTutor}", method = RequestMethod.POST)
	public String form_update(Tutor tutor, Long idTutor) {
		tutorRepository.findByIdTutor(idTutor);
		tutorRepository.save(tutor);
		return "redirect:/tutor/{idTutor}";
	}
}