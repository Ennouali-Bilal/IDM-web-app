package fr.insa.utils;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import fr.insa.model.Programme;
import fr.insa.model.Qcm;
import fr.insa.model.Question;
import fr.insa.model.Reponse;

public class PropertiesUtil {

	private String file;
	private Programme programme;

	public PropertiesUtil(String file) {
		this.file = file;
	}

	public boolean load() {

		try (InputStream input = getClass().getClassLoader().getResourceAsStream(file)) {

			Properties prop = new Properties();

			prop.load(input);

			int numQcms = Integer.parseInt(prop.getProperty("number"));
			programme = new Programme(numQcms);

			for (int i = 0; i < numQcms; i++) {

				String mode = prop.getProperty("mode" + i);
				String domaine = prop.getProperty("domaine" + i);
				int num_questions = Integer.parseInt(prop.getProperty("num_questions" + i));

				Qcm qcm = new Qcm(mode, domaine);

				for (int j = 0; j < num_questions; j++) {

					String question_data = prop.getProperty("question_data" + i + j);
					int num_reponses = Integer.parseInt(prop.getProperty("num_reponses" + i + j));

					Question q = new Question(question_data);

					for (int k = 0; k < num_reponses; k++) {

						String reponse_data = prop.getProperty("reponse_data" + i + j + k);
						String str_value = prop.getProperty("reponse_value" + i + j + k);
						boolean reponse_value = "true".equals(str_value) ? true : false;

						Reponse r = new Reponse(reponse_data, reponse_value);

						q.addReponse(r);
					}

					qcm.addQuestion(q);
				}

				programme.addQcm(qcm);
			}

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public Set<String> getAllDomaines() {

		Set<String> set = new HashSet<>();

		for (Qcm q : programme.getQcms()) {
			set.add(q.getDomaine());
		}

		return set;
	}

	public Qcm getQcm(String domaine) {

		for (Qcm q : programme.getQcms()) {

			if (q.getDomaine().equals(domaine)) {
				return q;
			}
		}

		return null;

	}

}
