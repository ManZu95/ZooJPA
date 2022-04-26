package it.majorbit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.majorbit.model.Animale;
import it.majorbit.repository.AnimaleRepository;

@Service
public class AnimaleService {
	@Autowired
	private AnimaleRepository animaleRepository;

	public ResponseEntity<Object> createAnimale(Animale animale) {
		animaleRepository.save(animale);
		return ResponseEntity.status(HttpStatus.OK).body("Aggiunta dell'animale avvenuta correttamente:\n" + animale);
	}

	public ResponseEntity<Object> updateAnimale(Integer codice, Double eta, String nome) {
		if (animaleRepository.existsById(codice)) {
			Animale animale = animaleRepository.findById(codice).get();
			if (eta < 0 || nome.length() < 4) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
						.body("Inserire un età accettabile e un nome che abbia almeno 4 caratteri");
			} else {
				animale.setEta(eta);
				animale.setNome(nome);
				animaleRepository.save(animale);
				return ResponseEntity.status(HttpStatus.OK).body("Animale aggiornato correttamente: \n" + animale);
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codice associato all'animale inesistente");
		}

	}

	public ResponseEntity<Object> readByName(String nome){
		Animale animale = animaleRepository.readByName(nome);
		return ResponseEntity.status(HttpStatus.OK).body("Animale ricercato: \n" + animale);
	}

	public ResponseEntity<String> deleteAnimale(String nome){
		animaleRepository.deleteByName(nome);
		return ResponseEntity.status(HttpStatus.OK).body("Animale eliminato correttamente");
	}
}
