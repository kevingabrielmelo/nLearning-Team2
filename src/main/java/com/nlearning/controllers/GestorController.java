package com.nlearning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nlearning.models.Gestor;
import com.nlearning.repository.GestorRepository;

@Controller
public class GestorController {

	@Autowired
	private GestorRepository gestorRepository;

	@RequestMapping(value = "/cadastrarGestor", method = RequestMethod.GET)
	public String form() {
		return "gestor/form_gestor";
	}

	@RequestMapping(value = "/cadastrarGestor", method = RequestMethod.POST)
	public String form(Gestor gestor) {
		gestorRepository.save(gestor);
		return "redirect:cadastrarGestor";
	}
}