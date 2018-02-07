package dev.paie.web.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.BulletinSalaireValidator;
import dev.paie.service.CalculerRemunerationService;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	private RemunerationEmployeRepository remEmplRepo;
	@Autowired
	private PeriodeRepository perRepo;
	@Autowired
	private BulletinSalaireRepository bulSalRepo;
	@Autowired
	private CalculerRemunerationService calRemServ;
	@Autowired
	private BulletinSalaireValidator bulSalValid;

	// page de création d'un bulletin
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("listEmployes", remEmplRepo.findAll());
		mv.addObject("listPeriodes", perRepo.findAll());
		mv.addObject("newBulletin", new BulletinSalaire());
		return mv;
	}

	// récupération d'un nouveau bulletin
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String creerBulletin(@ModelAttribute("newBulletin") BulletinSalaire newBulletin) {
		if(!bulSalValid.valider(newBulletin)) {
			return "redirect:/mvc/bulletins/creer?erreur";
		}
		bulSalRepo.save(newBulletin);
		return "redirect:/mvc/bulletins/lister";
	}
	
	// page d'erreur
	@RequestMapping(method = RequestMethod.GET, path = "/creer?erreur")
	public ModelAndView erreurCreation() {
		return creerBulletin();
	}

	// page d'affichage des bulletins
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletins() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletins");
		mv.addObject("listBulletins", calRemServ.mapCalculer());
		return mv;
	}

	// page d'affichage d'un bulletin
	@Transactional
	@RequestMapping(method = RequestMethod.GET, path = "/visualiser/{idBul}")
	public ModelAndView visualiserBulletin(@PathVariable Integer idBul) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/visualiserBulletin");
		BulletinSalaire bulletin = bulSalRepo.findOne(idBul);
		mv.addObject("bulletin", bulletin);
		mv.addObject("calculs", calRemServ.calculer(bulletin));
		return mv;
	}

}
