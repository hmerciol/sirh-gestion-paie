package dev.paie.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ProfilRemuneration extends Element {

	private String code;
	
	@ManyToMany
	@JoinTable(name = "profil_cotis_non_imp", 
		joinColumns = @JoinColumn(name = "profil_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "cotis_id", referencedColumnName = "id"))
	private List<Cotisation> cotisationsNonImposables;
	
	@ManyToMany
	@JoinTable(name = "profil_cotis_imp", 
		joinColumns = @JoinColumn(name = "profil_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "cotis_id", referencedColumnName = "id"))
	private List<Cotisation> cotisationsImposables;
	
	@ManyToMany
	private List<Avantage> avantages;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
