package it.majorbit.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.majorbit.model.Specie;
import it.majorbit.repository.SpecieRepository;

@Service
public class SpecieService {
	
	@Autowired
	private SpecieRepository specieRepository;
	
	public ResponseEntity<String> createSpecie(Specie specie){
		specieRepository.save(specie);
		return ResponseEntity.status(HttpStatus.OK).body("Specie aggiunta correttamente");
	}
}
