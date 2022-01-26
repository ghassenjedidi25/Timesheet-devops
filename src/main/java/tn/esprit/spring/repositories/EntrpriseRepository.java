package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Entreprise;

@Repository
public interface EntrpriseRepository extends CrudRepository<Entreprise, Long> {

}
