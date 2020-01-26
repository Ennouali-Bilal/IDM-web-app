package fr.insa.model;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private String data;

	private List<Reponse> reponses;

	private Reponse chosenReponse;
	
	public Question() {
	}
	
	public Question(String data) {
		this.data = data;
	}

	public Question(String data, List<Reponse> reponses, Reponse chosenReponse) {
		this.data = data;
		this.reponses = reponses;
		this.chosenReponse = chosenReponse;
	}

	public void addReponse(Reponse r) {

		if (reponses == null) {
			reponses = new ArrayList<Reponse>();
		}

		reponses.add(r);
	}

	public Reponse getTrueResponse() {

		for (Reponse r : reponses) {
			if (r.isValeur()) {
				return r;
			}
		}

		return null;
	}

	public boolean answeredCorrectly() {

		Reponse trueReponse = getTrueResponse();

		if (trueReponse == null || chosenReponse == null)
			return false;
		
		return trueReponse.getData().equals(this.chosenReponse.getData());
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public Reponse getChosenReponse() {
		return chosenReponse;
	}

	public void setChosenReponse(Reponse chosenReponse) {
		this.chosenReponse = chosenReponse;
	}

}
