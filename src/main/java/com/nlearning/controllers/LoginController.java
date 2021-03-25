package com.nlearning.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nlearning.models.Usuario;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String autenticacao() {
		return "login";
	}
	@PostMapping("/login")
	public String autenticar(HttpSession sessao, Usuario u) {
		// ir no banco, verificar...
		sessao.setAttribute("usuario", u);
		return "redirect:cadastrarAdmin";
	}
	@GetMapping("/logout")
	public String sair(HttpSession sessao) {
		sessao.invalidate();
		return "index";
	}
}