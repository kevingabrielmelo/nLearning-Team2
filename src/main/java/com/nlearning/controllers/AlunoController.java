package com.nlearning.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.models.Aluno;
import com.nlearning.models.Usuario;
import com.nlearning.repository.AlunoRepository;

@Controller
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@RequestMapping(value = "/cadastrarAluno", method = RequestMethod.GET)
	public String form(HttpSession sessao) {
		Usuario u = (Usuario) sessao.getAttribute("usuario");
		if (u == null) {
			return "redirect:login";
		} else {
			return "aluno/form_aluno";
		}
	}

	@RequestMapping(value = "/cadastrarAluno", method = RequestMethod.POST)
	public String form(Aluno aluno) {
		alunoRepository.save(aluno);
		return "redirect:cadastrarAluno";
	}

	@RequestMapping(value = "/aluno/{idAluno}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("idAluno") Long idAluno) {
		Aluno aluno = alunoRepository.findByIdAluno(idAluno);
		ModelAndView mv = new ModelAndView("aluno/update_aluno");
		mv.addObject("aluno", aluno);

		return mv;
	}

	@RequestMapping(value = "/aluno/{idAluno}", method = RequestMethod.POST)
	public String form_update(Aluno aluno, Long idAluno) {
		alunoRepository.findByIdAluno(idAluno);
		alunoRepository.save(aluno);
		return "redirect:/";
	}

//	@RequestMapping("/eventos")
//	public ModelAndView listaEventos() {
//		ModelAndView mv = new ModelAndView("/evento/visualizarEvento");
//		Iterable<Aluno> eventos = eventoRepository.findAll();
//		mv.addObject("eventos", eventos);
//		return mv;
//	}
//	
//	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
//	public ModelAndView detalhesEvento(@PathVariable("codigo") Long codigo) {
//		Aluno evento = eventoRepository.findByCodigo(codigo);
//		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
//		mv.addObject("evento", evento);
//		
//		Iterable<Convidado> convidados = cr.findByEvento(evento);
//		mv.addObject("convidados", convidados);
//		return mv;
//	}
//	
//	@RequestMapping("/deletar")
//	public String deletarEvento(Long codigo) {
//		Aluno evento = eventoRepository.findByCodigo(codigo);
//		eventoRepository.delete(evento);
//		return "redirect:/eventos";
//	}
//	
//	@RequestMapping("/deletarConvidado")
//	public String deletarConvidado(String rg) {
//		Convidado convidado = cr.findByRg(rg);
//		cr.delete(convidado);
//		
//		Aluno evento = convidado.getEvento();
//		long codigoLong = evento.getCodigo();
//		String codigo = "" + codigoLong;
//		return "redirect:/" + codigo;
//	}
//	
//	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
//	public String detalhesEventoPost(@PathVariable("codigo") Long codigo, Convidado convidado) {
//		Aluno evento = eventoRepository.findByCodigo(codigo);
//		convidado.setEvento(evento);
//		cr.save(convidado);
//		return "redirect:/{codigo}";
//	}
}
