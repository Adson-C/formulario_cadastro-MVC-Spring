package com.ads.dev.boot.web.controller.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ads.dev.boot.domain.Cargo;
import com.ads.dev.boot.service.CargoService;

@Component
public class StringToCargoConversor implements Converter<String, Cargo>{

	@Autowired
	private CargoService service;

	@Override
	public Cargo convert(String text) {
		if(text.isEmpty()) {
		return null;
	}
	
	Long id = Long.valueOf(text);
		return service.buscarPorId(id);

	}
}
