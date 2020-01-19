package fr.insa.model;

public class Reponse {

	private String data;

	private boolean valeur;

	public Reponse() {
	}

	public Reponse(String data, boolean valeur) {
		this.data = data;
		this.valeur = valeur;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isValeur() {
		return valeur;
	}

	public void setValeur(boolean valeur) {
		this.valeur = valeur;
	}

}
