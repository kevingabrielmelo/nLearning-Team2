package com.nlearning.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nlearning.models.Usuario;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		Usuario.tipoUsu = "";
		return "index";
	}
}