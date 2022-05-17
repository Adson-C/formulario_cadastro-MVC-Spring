package com.ads.dev.boot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ads.dev.boot.domain.Departamento;
import com.ads.dev.boot.service.DepartamenntoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamenntoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "/departamento/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) { // cria uma variavel 
		model.addAttribute("departamentos", service.buscarTodos());
		return "/departamento/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Departamento departamento,BindingResult result ,RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "/departamento/cadastro";
		}
		
		service.salvar(departamento);
		attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
		
		return "redirect:/departamentos/cadastrar"; // depois que salvar redireciona para pagina de cadastro
		
	}
	
	@GetMapping("/editar/{id}") // pega o id que esta na Url
	public String preEditar(@PathVariable("id") Long id, ModelMap model) { // ModelMap para poder enviar um departamento como uma variavél
		
		model.addAttribute("departamento", service.buscarPorId(id));
		
		return "/departamento/cadastro";
		
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Departamento departamento, BindingResult result ,RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "/departamento/cadastro";
		}
		
		service.editar(departamento);
		attr.addFlashAttribute("success", "Departamento editado com sucesso.");
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		
		if(service.departamentoTemCargo(id)) {
			model.addAttribute("fail", "Departamento não removido. Possui cargo(s) vinculados(s).");
		}
		else {
			service.excluir(id);
			model.addAttribute("success", "Departamento excluido com sucesso.");
		}
		
		return listar(model);
	}
	
}
