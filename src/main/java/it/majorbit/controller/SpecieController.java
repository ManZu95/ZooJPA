package it.majorbit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.majorbit.model.Animale;
import it.majorbit.model.Settore;
import it.majorbit.model.Specie;
import it.majorbit.service.SpecieService;

@Controller
@RequestMapping(value = "Specie")
public class SpecieController {
	
	@Autowired
	private SpecieService specieService;
	
	@PostMapping
	@RequestMapping(value = "Crea")
	public @ResponseBody ResponseEntity<Object> creaSpecie(@RequestBody Map<String, Object> parametri){
		Integer idSpecie = (Integer) parametri.get("idSpecie");
		String rarita = (String) parametri.get("rarita");
		Integer codiceAnimale = (Integer) parametri.get("codiceAnimale");
		Integer codiceSettore = (Integer) parametri.get("codiceSettore");
		
		if (idSpecie == null || rarita == "" || rarita == null || codiceAnimale == null || codiceSettore == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Parametri inseriti errati");
		}
		Animale animale = new Animale();
		animale.setCodice(codiceAnimale);
		Settore settore = new Settore();
		settore.setId(codiceSettore);
		Specie specie = new Specie();
		specie.setIdSpecie(idSpecie);
		specie.setRarita(rarita);
		specie.setAnimali(animale);
		specie.setSettore(settore);
		
		return null;
	}

}
