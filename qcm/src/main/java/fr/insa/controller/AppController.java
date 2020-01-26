package fr.insa.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.model.Qcm;
import fr.insa.model.Question;
import fr.insa.utils.PropertiesUtil;

@RestController
@RequestMapping("/api")
public class AppController {

	private PropertiesUtil props;
	private Set<String> domaines;

	@GetMapping("/domaines")
	public ResponseEntity<?> domaines() {

		if (props == null) {
			props = new PropertiesUtil("data.properties");
		}

		props.load();

		domaines = props.getAllDomaines();

		return new ResponseEntity<>(domaines, HttpStatus.OK);
	}

	@GetMapping("/qcm")
	public ResponseEntity<?> qcm(@RequestParam("domaine") String domaine) {

		if (props == null) {
			props = new PropertiesUtil("data.properties");
		}

		Qcm q = props.getQcm(domaine);

		if (q == null) {
			return new ResponseEntity<>("This is not a valid domain", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(q, HttpStatus.OK);

	}

	@PostMapping("/qcm")
	public ResponseEntity<?> sendQcm(@Valid @RequestBody Qcm q) {

		int score = 0;

		// calculate the score
		for (Question itr : q.getQuestions()) {
			if (itr.answeredCorrectly()) {
				score++;
			}
		}

		return new ResponseEntity<>(score + "/" + q.getQuestions().size(), HttpStatus.OK);

	}
}
