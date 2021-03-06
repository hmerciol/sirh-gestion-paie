package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Grade extends Element {

	private String code;
	@Column(precision = 19, scale = 2)
	private BigDecimal nbHeuresBase;
	@Column(precision = 19, scale = 6)
	private BigDecimal tauxBase;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}

	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}

	public BigDecimal getTauxBase() {
		return tauxBase;
	}

	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}
	
	public String getLabel() {
		return code + " - " + nbHeuresBase.multiply(tauxBase).multiply(new BigDecimal("12.0")).intValue() + " € / an";
	}

}
