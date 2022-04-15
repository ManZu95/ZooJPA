package it.majorbit.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.majorbit.model.Animale;

@Repository
public interface AnimaleRepository extends CrudRepository<Animale, Integer> {
	
	@Modifying
	@Query( value = "delete from Animale where nome = :nome")
	@Transactional
	public void deleteByName(String nome);
	
	@Query( value = "from Animale where nome = :nome")
	public Animale readByName(String nome);

}
