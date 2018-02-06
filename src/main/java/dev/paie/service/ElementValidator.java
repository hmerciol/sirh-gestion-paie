package dev.paie.service;

import dev.paie.entite.Element;

@FunctionalInterface
public interface ElementValidator {
	
	boolean valider(Element element);

}
