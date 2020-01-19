package fr.insa.model;

import java.util.ArrayList;
import java.util.List;

public class Programme {

	private int numQcm;

	private List<Qcm> qcms;

	public Programme() {
	}

	public Programme(int numQcm) {
		this.numQcm = numQcm;
	}

	public void addQcm(Qcm qcm) {

		if (qcms == null) {
			qcms = new ArrayList<Qcm>();
		}

		qcms.add(qcm);
	}

	public int getNumQcm() {
		return numQcm;
	}

	public void setNumQcm(int numQcm) {
		this.numQcm = numQcm;
	}

	public List<Qcm> getQcms() {
		return qcms;
	}

	public void setQcms(List<Qcm> qcms) {
		this.qcms = qcms;
	}

}
