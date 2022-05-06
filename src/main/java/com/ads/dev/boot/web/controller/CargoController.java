package com.ads.dev.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ads.dev.boot.domain.Cargo;
import com.ads.dev.boot.domain.Departamento;
import com.ads.dev.boot.service.CargoService;
import com.ads.dev.boot.service.DepartamenntoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	CargoService cargoService;
	
	@Autowired
	DepartamenntoService departamenntoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "cargo/cadastro";
	}

	@GetMapping("/listar")
	public String listar() {
		return "cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cargo cargo, RedirectAttributes attr ) {
		
		cargoService.salvar(cargo);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso");
		return "redirect:/cargos/cadastrar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDepartamentos() {
		return departamenntoService.buscarTodos();
	}

}
