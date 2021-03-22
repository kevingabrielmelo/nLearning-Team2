package com.nlearning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.models.Admin;
import com.nlearning.repository.AdminRepository;

@Controller
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;

	@RequestMapping(value = "/cadastrarAdmin", method = RequestMethod.GET)
	public String form() {
		return "admin/form_admin";
	}

	@RequestMapping(value = "/cadastrarAdmin", method = RequestMethod.POST)
	public String form(Admin admin) {
		adminRepository.save(admin);
		return "redirect:cadastrarAdmin";
	}
	
	@RequestMapping(value = "/admin/{idAdmin}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("idAdmin") Long idAdmin) {
		Admin admin = adminRepository.findByIdAdmin(idAdmin);
		ModelAndView mv = new ModelAndView("admin/update_admin");
		mv.addObject("admin", admin);
		
		return mv;
	}

	@RequestMapping(value = "/admin/{idAdmin}", method = RequestMethod.POST)
	public String form_update(Admin admin , Long idAdmin) {
		adminRepository.findByIdAdmin(idAdmin);
		adminRepository.save(admin);
		return "redirect:/";
	}
}
