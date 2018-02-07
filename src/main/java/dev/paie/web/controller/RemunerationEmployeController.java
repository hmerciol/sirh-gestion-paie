package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.RemunerationEmployeValidator;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private EntrepriseRepository entRepo;
	@Autowired
	private ProfilRemunerationRepository profRepo;
	@Autowired
	private GradeRepository graRepo;
	@Autowired
	private RemunerationEmployeRepository remEmplRepo;
	@Autowired
	private RemunerationEmployeValidator remEmplValid;

	// page de création d'un employé
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("listEntreprises", entRepo.findAll());
		mv.addObject("listProfils", profRepo.findAll());
		mv.addObject("listGrades", graRepo.findAll());
		mv.addObject("newEmploye", new RemunerationEmploye());
		return mv;
	}

	// récupération d'un nouvel employé
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public String creerEmploye(@ModelAttribute("newEmploye") RemunerationEmploye newEmploye) {
		if (!remEmplValid.valider(newEmploye)) {
			return "redirect:/mvc/employes/creer?erreur";
		}
		remEmplRepo.save(newEmploye);
		return "redirect:/mvc/employes/lister";
	}

	// page d'affichage des employés
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView listerEmployes() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmployes");
		mv.addObject("listEmployes", remEmplRepo.findAll());
		return mv;
	}

}
