package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Employe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String prenom;

	private String nom;

	private String email;

	private String password;

	private boolean actif;

	@OneToOne
	private Contrat contrat;

	public Employe() {
		super();
	}

	public Employe(Long id, String prenom, String nom, String email, String password, boolean actif) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.actif = actif;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}