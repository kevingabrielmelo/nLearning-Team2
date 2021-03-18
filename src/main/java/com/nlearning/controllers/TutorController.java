package com.nlearning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nlearning.models.Tutor;
import com.nlearning.repository.TutorRepository;

@Controller
public class TutorController {

	@Autowired
	private TutorRepository tutorRepository;
	
	@RequestMapping(value="/cadastrarTutor", method=RequestMethod.GET)
	public String form() {
		return "tutor/form_tutor";
	}
	
	@RequestMapping(value="/cadastrarTutor", method=RequestMethod.POST)
	public String form(Tutor tutor) {
		tutorRepository.save(tutor);
		return "redirect:cadastrarTutor";
	}
}