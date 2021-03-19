package com.nlearning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
