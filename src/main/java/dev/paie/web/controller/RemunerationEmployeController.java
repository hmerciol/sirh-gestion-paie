package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("listEntreprises", entRepo.findAll());
		mv.addObject("listProfils", profRepo.findAll());
		mv.addObject("listGrades", graRepo.findAll());
		mv.addObject("newEmploye", new RemunerationEmploye());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String creerEmploye(@ModelAttribute("newEmploye") RemunerationEmploye newEmploye) {
		remEmplRepo.save(newEmploye);
		return "redirect:/";
	}

}
