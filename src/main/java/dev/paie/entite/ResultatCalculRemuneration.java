package dev.paie.entite;

import org.springframework.stereotype.Component;

@Component
public class ResultatCalculRemuneration {

	private String salaireDeBase;
	private String salaireBrut;
	private String totalRetenueSalarial;
	private String totalCotisationsPatronales;
	private String netImposable;
	private String netAPayer;

	/**
	 * Getter for the salaireDeBase
	 * 
	 * @return the salaireDeBase
	 */
	public String getSalaireDeBase() {
		return salaireDeBase;
	}

	/**
	 * Setter for the salaireDeBase
	 * 
	 * @param salaireDeBase
	 *            the salaireDeBase to set
	 */
	public void setSalaireDeBase(String salaireDeBase) {
		this.salaireDeBase = salaireDeBase;
	}

	/**
	 * Getter for the salaireBrut
	 * 
	 * @return the salaireBrut
	 */
	public String getSalaireBrut() {
		return salaireBrut;
	}

	/**
	 * Setter for the salaireBrut
	 * 
	 * @param salaireBrut
	 *            the salaireBrut to set
	 */
	public void setSalaireBrut(String salaireBrut) {
		this.salaireBrut = salaireBrut;
	}

	/**
	 * Getter for the totalRetenueSalarial
	 * 
	 * @return the totalRetenueSalarial
	 */
	public String getTotalRetenueSalarial() {
		return totalRetenueSalarial;
	}

	/**
	 * Setter for the totalRetenueSalarial
	 * 
	 * @param totalRetenueSalarial
	 *            the totalRetenueSalarial to set
	 */
	public void setTotalRetenueSalarial(String totalRetenueSalarial) {
		this.totalRetenueSalarial = totalRetenueSalarial;
	}

	/**
	 * Getter for the totalCotisationsPatronales
	 * 
	 * @return the totalCotisationsPatronales
	 */
	public String getTotalCotisationsPatronales() {
		return totalCotisationsPatronales;
	}

	/**
	 * Setter for the totalCotisationsPatronales
	 * 
	 * @param totalCotisationsPatronales
	 *            the totalCotisationsPatronales to set
	 */
	public void setTotalCotisationsPatronales(String totalCotisationsPatronales) {
		this.totalCotisationsPatronales = totalCotisationsPatronales;
	}

	/**
	 * Getter for the netImposable
	 * 
	 * @return the netImposable
	 */
	public String getNetImposable() {
		return netImposable;
	}

	/**
	 * Setter for the netImposable
	 * 
	 * @param netImposable
	 *            the netImposable to set
	 */
	public void setNetImposable(String netImposable) {
		this.netImposable = netImposable;
	}

	/**
	 * Getter for the netAPayer
	 * 
	 * @return the netAPayer
	 */
	public String getNetAPayer() {
		return netAPayer;
	}

	/**
	 * Setter for the netAPayer
	 * 
	 * @param netAPayer
	 *            the netAPayer to set
	 */
	public void setNetAPayer(String netAPayer) {
		this.netAPayer = netAPayer;
	}

}
