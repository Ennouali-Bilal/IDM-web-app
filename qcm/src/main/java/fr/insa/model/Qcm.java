package fr.insa.model;

import java.util.ArrayList;
import java.util.List;

public class Qcm {

	private String mode;

	private String domaine;

	private List<Question> questions;

	public Qcm() {
	}

	public Qcm(String mode, String domaine) {
		this.mode = mode;
		this.domaine = domaine;
	}

	public void addQuestion(Question q) {

		if (questions == null) {
			questions = new ArrayList<Question>();
		}

		questions.add(q);

	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
