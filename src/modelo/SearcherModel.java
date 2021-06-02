package modelo;

import java.util.ArrayList;

public class SearcherModel {
	
	public SearcherModel() {

	}

	public ArrayList<Locality> getLocality(String textString) {
		Locality locality1 = new Locality(1, "Vitoria", 1001, 100);
		Locality locality2 = new Locality(1, "Victoria", 1002, 100);
		Locality locality3 = new Locality(1, "Vista Alegre", 1003, 100);
		ArrayList<Locality> localities = new ArrayList<>();
		localities.add(locality1);
		localities.add(locality2);
		localities.add(locality3);

		return localities;
	}

	public ProcessedData getProcessedData(Locality localidad) {
		ProcessedData processedData = new ProcessedData(localidad, 25);
		return processedData;
	}

	/*public PastData[] getPastData(Locality localidad) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}
