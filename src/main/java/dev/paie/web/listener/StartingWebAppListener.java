package dev.paie.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import dev.paie.service.InitialiserDonneesService;

@Service
public class StartingWebAppListener {
	
	@Autowired
	private InitialiserDonneesService initDataService;
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		// capture du démarrage de l'application
		// à un moment où le contexte Spring est complètement créé
		initDataService.initialiser();
	}

}
