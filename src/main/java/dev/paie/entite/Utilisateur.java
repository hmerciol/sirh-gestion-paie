package dev.paie.entite;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Utilisateur extends Element {

	public enum ROLES {
		ROLE_ADMINISTRATEUR, ROLE_UTILISATEUR
	}

	private String nomUtilisateur;
	private String motDePasse;
	private Boolean estActif;
	@Enumerated(EnumType.STRING)
	private ROLES role;
	
	/**
	 * Getter for the nomUtilisateur
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	
	/**
	 * Setter for the nomUtilisateur
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	
	/**
	 * Getter for the motDePasse
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	
	/**
	 * Setter for the motDePasse
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	/**
	 * Getter for the estActif
	 * @return the estActif
	 */
	public Boolean getEstActif() {
		return estActif;
	}
	
	/**
	 * Setter for the estActif
	 * @param estActif the estActif to set
	 */
	public void setEstActif(Boolean estActif) {
		this.estActif = estActif;
	}
	
	/**
	 * Getter for the role
	 * @return the role
	 */
	public ROLES getRole() {
		return role;
	}
	
	/**
	 * Setter for the role
	 * @param role the role to set
	 */
	public void setRole(ROLES role) {
		this.role = role;
	}

}
