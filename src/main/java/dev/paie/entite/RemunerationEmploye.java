package dev.paie.entite;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class RemunerationEmploye extends Element {

	private String matricule;
	@ManyToOne
	private Entreprise entreprise;
	@ManyToOne
	private ProfilRemuneration profilRemuneration;
	@ManyToOne
	private Grade grade;
	private LocalDate creationDate;
	private LocalTime creationTime;

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}

	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalTime creationTime) {
		this.creationTime = creationTime;
	}

}
