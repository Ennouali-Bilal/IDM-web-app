package fr.insa.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.insa.model.Qcm;
import fr.insa.model.Question;
import fr.insa.utils.PropertiesUtil;

@Controller
@RequestMapping("/app")
public class AppController {

	private PropertiesUtil props;
	private Set<String> domaines;
	private int score;
	private Qcm qcm;

	@GetMapping("index")
	public String index(Model model) {

		props = new PropertiesUtil("data.properties");

		props.load();

		domaines = props.getAllDomaines();

		model.addAttribute("domaines", domaines);

		Qcm q = new Qcm();

		model.addAttribute("qcm", q);

		return "index";
	}

	@PostMapping("qcm")
	public String qcm(@ModelAttribute("qcm") Qcm formQcm, Model model) {

		Qcm q = props.getQcm(formQcm.getDomaine(), formQcm.getMode());

		model.addAttribute("qcm", q);
		
		this.qcm = q;

		return "qcm";
	}

	@PostMapping("sendqcm")
	public String sendqcm(@ModelAttribute("qcm") Qcm formQcm, Model model) {
		
		System.out.println("Domaine -> " + formQcm.getDomaine());
		System.out.println("Mode -> " + formQcm.getMode());
		
		for(Question q : formQcm.getQuestions()) {
			System.out.println(q.getChosenReponse());
		}
		
		System.out.println("formQcm -> " + formQcm.getQuestions());
		
		for (Question q : formQcm.getQuestions()) {
			if (q.answeredCorrectly())
				score++;
		}
		
		model.addAttribute("score", score);

		if (formQcm.getMode().equals("Examen")) {
			return "fin";
		}

		return "reponses";
	}

	@PostMapping("fin")
	public String fin() {
		return "fin";
	}

}
