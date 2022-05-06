package com.ads.dev.boot.web.controller.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ads.dev.boot.domain.Departamento;
import com.ads.dev.boot.service.DepartamenntoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento>{
	
	@Autowired
	private DepartamenntoService service;

	@Override
	public Departamento convert(String text) {
		if(text.isEmpty()) { // teste para garantir se tiver vazia não vai ser convertida
			return null;
		}
		
		Long id = Long.valueOf(text); // aparti do texto converte para objeto Long
		return service.buscarPorId(id);
	}

}
