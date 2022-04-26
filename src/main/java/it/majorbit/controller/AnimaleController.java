package it.majorbit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import it.majorbit.model.Animale;
import it.majorbit.service.AnimaleService;

@Controller
@RequestMapping(value = "Animale")
public class AnimaleController {
	
	@Autowired
	private AnimaleService animaleService;
	
	@PostMapping
	@RequestMapping(value = "Crea")
	public @ResponseBody ResponseEntity<Object> createAnimale(@RequestBody Map<String, Object> parametri){
		Double eta = (Double) parametri.get("eta");
		String nome = (String) parametri.get("nome");
		
		if (eta == null || nome == null || nome == "") {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Errore nell'aggiunta dell'animale");
		}
		
		Animale animale = new Animale();
		animale.setEta(eta);
		animale.setNome(nome);		
		
		return animaleService.createAnimale(animale);
	}
	
	@GetMapping
	@RequestMapping(value = "Leggi")
	public @ResponseBody ResponseEntity<Object> readAnimale(@RequestParam String nome){
		if (nome == null || nome == "") {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Inserisci correttamente i valori");
		}
		return animaleService.readByName(nome);
	}
	
	@PutMapping 
	@RequestMapping(value = "Modifica")
	public @ResponseBody ResponseEntity<Object> updateAnimale(@RequestBody Map<String, Object> parametri){
		Integer codice = (Integer) parametri.get("codice");
		Double eta = (Double) parametri.get("eta");
		String nome = (String) parametri.get("nome");
		
		if (codice == null || eta == null || nome == null || nome == "") {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Errore nell'inserimento dei parametri");
		}
		
		return animaleService.updateAnimale(codice, eta, nome);
	}
	
	@DeleteMapping("/{nome}")
	public @ResponseBody ResponseEntity<String> deleteAnimale(@PathVariable("nome") String nome){
		if (nome == null || nome == "") {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Inserisci correttamente i valori");
		}
		return animaleService.deleteAnimale(nome);
	}
}
