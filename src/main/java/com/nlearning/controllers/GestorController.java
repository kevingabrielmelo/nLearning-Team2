package com.nlearning.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.models.Gestor;
import com.nlearning.models.Usuario;
import com.nlearning.repository.GestorRepository;

@Controller
public class GestorController {

	@Autowired
	private GestorRepository gestorRepository;

	@RequestMapping(value = "/cadastrarGestor", method = RequestMethod.GET)
	public String form(HttpSession sessao) {
		Usuario u = (Usuario) sessao.getAttribute("usuario");
		if (u == null) {
			return "redirect:login";
		} else {
			return "gestor/form_gestor";
		}
	}

	@RequestMapping(value = "/cadastrarGestor", method = RequestMethod.POST)
	public String form(Gestor gestor) {
		gestorRepository.save(gestor);
		return "redirect:cadastrarGestor";
	}

	@RequestMapping(value = "/gestor/{idGestor}", method = RequestMethod.GET)
	public String gestor(HttpSession sessao) {
		Usuario u = (Usuario) sessao.getAttribute("usuario");
		if (u == null) {
			return "redirect:/login";
		} else {
			return "gestor/form_gestor";
		}
	}
	public ModelAndView detalhesEvento(@PathVariable("idGestor") Long idGestor) {
		Gestor gestor = gestorRepository.findByIdGestor(idGestor);
		ModelAndView mv = new ModelAndView("gestor/update_gestor");
		mv.addObject("gestor", gestor);

		return mv;
	}

	@RequestMapping(value = "/gestor/{idGestor}", method = RequestMethod.POST)
	public String form_update(Gestor gestor, Long idGestor) {
		gestorRepository.findByIdGestor(idGestor);
		gestorRepository.save(gestor);
		return "redirect:/";
	}
}