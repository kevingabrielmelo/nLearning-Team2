package com.nlearning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nlearning.models.Aluno;
import com.nlearning.repository.AlunoRepository;

@Controller
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@RequestMapping(value="/cadastrarAluno", method=RequestMethod.GET)
	public String form() {
		return "aluno/form_aluno";
	}
	
	@RequestMapping(value="/cadastrarAluno", method=RequestMethod.POST)
	public String form(Aluno aluno) {
		alunoRepository.save(aluno);
		return "redirect:cadastrarAluno";
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
