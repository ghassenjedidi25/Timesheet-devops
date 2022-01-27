package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Departement;



public interface DepartementRepository extends CrudRepository<Departement, Long> {

}
