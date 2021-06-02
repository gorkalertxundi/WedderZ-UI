package edu.wedderz.core.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.swing.JComboBox;

import edu.wedderz.core.app.model.SearcherModel;
import edu.wedderz.core.app.view.BusquedaLocalidades;
import edu.wedderz.core.app.view.LocationSelectionPanel;
import edu.wedderz.core.app.view.UIFrame;
import edu.wedderz.core.app.view.WeatherPanel;
import edu.wedderz.core.model.DataType;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.ProcessedData;

public class SearcherController implements ActionListener{
	
	String searchField;
	SearcherModel model;
	BusquedaLocalidades viewSearcher;
	WeatherPanel weatherPanel;
	UIFrame uiFrame;
	LocationSelectionPanel locationSelectionPanel;
	
	Set<Locality> localities;
	
	public SearcherController(BusquedaLocalidades view, WeatherPanel weatherPanel, SearcherModel model, 
			LocationSelectionPanel locationSelectionPanel, UIFrame uiFrame) {
		this.model = model;
		this.viewSearcher = view;
		this.weatherPanel = weatherPanel;
		this.locationSelectionPanel = locationSelectionPanel;
		this.uiFrame = uiFrame;
		locationSelectionPanel.setActionListener(this);
	}
	
	public void setValuesTEMPORAL() {
		weatherPanel.setCurrentWeatherValues("Orio", "ES", 0, 26, 15, 27, 1018.3, 66, 3.47);
		weatherPanel.setPast1DaysValues(getDayString(1), 1, 19.4, 15, 22, 43);
		weatherPanel.setPast2DaysValues(getDayString(2), 2, 13.8, 15, 22, 43);
		weatherPanel.setPast3DaysValues(getDayString(3), 3, 9.5, 15, 22, 43);
		weatherPanel.setPast4DaysValues(getDayString(4), 4, 4.3, 15, 22, 43);
		weatherPanel.setPast5DaysValues(getDayString(5), 5, -3.6, 15, 22, 43);
		
	}
	private void setValuesWeather(Locality localityToShow) {
		weatherPanel.setCurrentWeatherValues(localityToShow.getName(), localityToShow.getCountry().getCountryId().toUpperCase(), 5, 10, 8, 15, 1018.3, 66, 3.47);
		weatherPanel.setPast1DaysValues(getDayString(1), 1, 19.4, 15, 22, 43);
		weatherPanel.setPast2DaysValues(getDayString(2), 2, 13.8, 15, 22, 43);
		weatherPanel.setPast3DaysValues(getDayString(3), 3, 9.5, 15, 22, 43);
		weatherPanel.setPast4DaysValues(getDayString(4), 4, 4.3, 15, 22, 43);
		weatherPanel.setPast5DaysValues(getDayString(5), 5, -3.6, 15, 22, 43);		
	}
	
	private String getDayString(int n) { 
		Date date = new Date(System.currentTimeMillis()-n*24*60*60*1000);
	    DateFormat formatter = new SimpleDateFormat("EEEE");
	    char[] arr = formatter.format(date).toCharArray();
	    arr[0] = Character.toUpperCase(arr[0]);
	    return new String(arr);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "searchButton") {
			String textString = viewSearcher.getTextField();
			if(textString.equals("")) {
				viewSearcher.changePanelToNotFound();
			}
			else {
				localities = model.getLocality(textString);
				if(localities == null) {
					viewSearcher.changePanelToNotFound();
				}
				else {
					locationSelectionPanel.putLocalities(localities);
					viewSearcher.changePanelToSelection();
				}
			}
			
			uiFrame.refresh();
		
		}
		else if(e.getActionCommand() == "Selection") {
			boolean salir = true;
			int i = 0;
			Locality localityToShow = null;
			JComboBox<String> comboBox = (JComboBox<String>) locationSelectionPanel.getComboBox();
			String localidadNombre = (String) comboBox.getSelectedItem();
			Object[] localidadesArrayList = localities.toArray();

			while(salir) { 
				if(((Locality)localidadesArrayList[i]).getName().equals(localidadNombre)) {
					salir = false;
					localityToShow = ((Locality)localidadesArrayList[i]);
				}
				else {
					i++;
				}
			}
			Set<ProcessedData> processedData = model.getProcessedData(localityToShow);
			viewSearcher.changePanelToData();
			setValuesWeather(localityToShow);
			uiFrame.refresh();

		}
	}


	

}
