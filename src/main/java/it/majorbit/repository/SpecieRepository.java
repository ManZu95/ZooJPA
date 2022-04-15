package it.majorbit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.majorbit.model.Specie;

@Repository
public interface SpecieRepository extends CrudRepository<Specie, String>{

}
