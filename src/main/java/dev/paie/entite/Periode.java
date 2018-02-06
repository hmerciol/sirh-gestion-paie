package dev.paie.entite;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;

@Entity
public class Periode extends Element {

	private LocalDate dateDebut;
	private LocalDate dateFin;

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public String getLabel() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dateDebut.format(formatter) + " - " + dateFin.format(formatter);
	}

}
