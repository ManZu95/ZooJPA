package it.majorbit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.majorbit.model.Settore;

@Repository
public interface SettoreRepository extends CrudRepository<Settore, Integer> {

}
