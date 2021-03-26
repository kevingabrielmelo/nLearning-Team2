package com.nlearning.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.models.Admin;
import com.nlearning.models.Usuario;
import com.nlearning.repository.AdminRepository;

@Controller
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;

	// Validação de login (MENU)
	@RequestMapping(value = "/menuAdmin", method = RequestMethod.GET)
	public String checkMenu(HttpSession sessao) {
		if (Usuario.tipoUsu != "admin") {
			return "redirect:login";
		} else {
			return "admin/menu_admin";
		}
	}

	// Validação de login (UPDATE)
	@RequestMapping(value = "/update_admin")
	public String checkUpdate(Long idAdmin) {
		if (Usuario.tipoUsu != "admin") {
			return "redirect:login";
		} else {
			return "redirect:alterarDadosAdmin";
		}
	}

	// Encontra os dados do admin alvo
	@RequestMapping(value = "alterarDadosAdmin", method = RequestMethod.GET)
	public ModelAndView dadosAdmin(Long idAdmin) {
		Admin admin = adminRepository.findByIdAdmin(Usuario.idUsu);
		ModelAndView mv = new ModelAndView("admin/update_admin");
		mv.addObject("admin", admin);

		return mv;
	}

	// Salva os dados do admin alvo e atualiza no banco
	@RequestMapping(value = "alterarDadosAdmin", method = RequestMethod.POST)
	public String form_update(Admin admin, Long idAdmin) {
		admin.setIdAdmin(Usuario.idUsu);
		adminRepository.save(admin);
		return "redirect:alterarDadosAdmin";
	}

	// Não está sendo utilizado (Cadastrar ADM)
	/*
	 * @RequestMapping(value = "/cadastrarAdmin", method = RequestMethod.POST)
	 * public String form(Admin admin) { adminRepository.save(admin); return
	 * "redirect:cadastrarAdmin"; }
	 */

}
