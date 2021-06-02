package edu.wedderz.core.app.model;

import java.util.HashSet;
import java.util.Set;

import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.ProcessedData;

public class SearcherModel {
	
	public SearcherModel() {

	}

	public Set<Locality> getLocality(String textString) {
		Locality locality1 = null;
		Locality locality2 = null;
		Locality locality3 = null;
//		Locality locality1 = new Locality(1, "Vitoria", 1001, 100);
//		Locality locality2 = new Locality(1, "Victoria", 1002, 100);
//		Locality locality3 = new Locality(1, "Vista Alegre", 1003, 100);
		Set<Locality> localities = new HashSet<>();
		localities.add(locality1);
		localities.add(locality2);
		localities.add(locality3);

		return localities;
	}

	public ProcessedData getProcessedData(Locality localidad) {
		ProcessedData processedData = null;
//		ProcessedData processedData = new ProcessedData(localidad, 25);
		return processedData;
	}

	/*public PastData[] getPastData(Locality localidad) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}
