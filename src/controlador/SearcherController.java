package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Locality;
import modelo.ProcessedData;
import modelo.SearcherModel;
import vista.BusquedaLocalidades;
import vista.WeatherPanel;

public class SearcherController implements ActionListener{
	
	String searchField;
	SearcherModel model;
	BusquedaLocalidades viewSearcher;
	WeatherPanel weatherPanel;

	public SearcherController(BusquedaLocalidades view, WeatherPanel weatherPanel, SearcherModel model) {
		this.model = model;
		this.viewSearcher = view;
		this.weatherPanel = weatherPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "searchButton") {
			String textString = viewSearcher.getTextField();
			Locality locality = new Locality(1, textString, 1000, 500);
			//buscar localidad en la datu basea
			//y luego coger los datos
			
			Locality localidad = model.getLocality(textString);
			ProcessedData data = model.getProcessedData(localidad);
			
			weatherPanel.updateLocalization(locality, data);
		}
	}

}
