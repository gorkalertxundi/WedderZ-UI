package edu.wedderz.core.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JComboBox;

import edu.wedderz.core.app.model.SearcherModel;
import edu.wedderz.core.app.view.BusquedaLocalidades;
import edu.wedderz.core.app.view.LocationSelectionPanel;
import edu.wedderz.core.app.view.UIFrame;
import edu.wedderz.core.app.view.WeatherPanel;
import edu.wedderz.core.model.DataType;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Data;

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
	private void setValuesWeatherDay5(Set<Data> set) {
		Data presionData = null, temperaturaMax = null, temperaturaMin = null, temperaturaMedia = null, viento = null, humedadData = null;
		Iterator<Data> iterator = set.iterator();
		while(iterator.hasNext()) {
			Data processedData = iterator.next();
			if (processedData.getDataType().getDescription().equals("Humedad")) {
				humedadData = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Velocidad de viento")) {
				viento = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura mínima")) {
				temperaturaMin = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Presión")) {
				presionData = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura máxima")) {
				temperaturaMax = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura")) {
				temperaturaMedia = processedData;
			}

		}
		weatherPanel.setPast5DaysValues(getDayString(5), 1, temperaturaMedia.getValue(), temperaturaMin.getValue(), temperaturaMax.getValue(), humedadData.getValue());		
	}
	private void setValuesWeatherDay4(Set<Data> set) {
		Data presionData = null, temperaturaMax = null, temperaturaMin = null, temperaturaMedia = null, viento = null, humedadData = null;
		Iterator<Data> iterator = set.iterator();
		while(iterator.hasNext()) {
			Data processedData = iterator.next();
			if (processedData.getDataType().getDescription().equals("Humedad")) {
				humedadData = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Velocidad de viento")) {
				viento = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura mínima")) {
				temperaturaMin = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Presión")) {
				presionData = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura máxima")) {
				temperaturaMax = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura")) {
				temperaturaMedia = processedData;
			}

		}
		weatherPanel.setPast4DaysValues(getDayString(4), 5, temperaturaMedia.getValue(), temperaturaMin.getValue(), temperaturaMax.getValue(), humedadData.getValue());		
	}
	private void setValuesWeatherDay3(Set<Data> set) {
		Data presionData = null, temperaturaMax = null, temperaturaMin = null, temperaturaMedia = null, viento = null, humedadData = null;
		Iterator<Data> iterator = set.iterator();
		while(iterator.hasNext()) {
			Data processedData = iterator.next();
			if (processedData.getDataType().getDescription().equals("Humedad")) {
				humedadData = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Velocidad de viento")) {
				viento = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura mínima")) {
				temperaturaMin = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Presión")) {
				presionData = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura máxima")) {
				temperaturaMax = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura")) {
				temperaturaMedia = processedData;
			}

		}
		weatherPanel.setPast3DaysValues(getDayString(3), 5, temperaturaMedia.getValue(), temperaturaMin.getValue(), temperaturaMax.getValue(), humedadData.getValue());		
	}
	private void setValuesWeatherDay2(Set<Data> set) {
		Data presionData = null, temperaturaMax = null, temperaturaMin = null, temperaturaMedia = null, viento = null, humedadData = null;
		Iterator<Data> iterator = set.iterator();
		while(iterator.hasNext()) {
			Data processedData = iterator.next();
			if (processedData.getDataType().getDescription().equals("Humedad")) {
				humedadData = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Velocidad de viento")) {
				viento = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura mínima")) {
				temperaturaMin = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Presión")) {
				presionData = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura máxima")) {
				temperaturaMax = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura")) {
				temperaturaMedia = processedData;
			}

		}
		weatherPanel.setPast2DaysValues(getDayString(2), 5, temperaturaMedia.getValue(), temperaturaMin.getValue(), temperaturaMax.getValue(), humedadData.getValue());		
	}
	private void setValuesWeatherDay1(Set<Data> set) {
		Data presionData = null, temperaturaMax = null, temperaturaMin = null, temperaturaMedia = null, viento = null, humedadData = null;
		Iterator<Data> iterator = set.iterator();
		while(iterator.hasNext()) {
			Data processedData = iterator.next();
			if (processedData.getDataType().getDescription().equals("Humedad")) {
				humedadData = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Velocidad de viento")) {
				viento = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura mínima")) {
				temperaturaMin = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Presión")) {
				presionData = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura máxima")) {
				temperaturaMax = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura")) {
				temperaturaMedia = processedData;
			}

		}
		weatherPanel.setPast1DaysValues(getDayString(1), 3, temperaturaMedia.getValue(), temperaturaMin.getValue(), temperaturaMax.getValue(), humedadData.getValue());		
	}
	private void setValuesWeatherToday(Locality localityToShow, Set<Data> set) {
		Data presionData = null, temperaturaMax = null, temperaturaMin = null, temperaturaMedia = null, viento = null, humedadData = null;
		Iterator<Data> iterator = set.iterator();
		while(iterator.hasNext()) {
			Data processedData = iterator.next();
			if (processedData.getDataType().getDescription().equals("Humedad")) {
				humedadData = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Velocidad de viento")) {
				viento = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura mínima")) {
				temperaturaMin = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Presión")) {
				presionData = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura máxima")) {
				temperaturaMax = processedData;
			}
			else if(processedData.getDataType().getDescription().equals("Temperatura")) {
				temperaturaMedia = processedData;
			}

		}
		weatherPanel.setCurrentWeatherValues(localityToShow.getName(), 
				localityToShow.getCountry().getCountryId(), 3, temperaturaMedia.getValue(), temperaturaMin.getValue(), 
				temperaturaMax.getValue(), presionData.getValue(), humedadData.getValue(),
				viento.getValue());
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
				if(localities.size() == 0) {
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
			
			Map<Date, Set<Data>> processedDatas = model.getProcessedData(localityToShow);
			
			NavigableSet<Date> navigableSet = ((TreeMap) processedDatas).descendingKeySet();
			Iterator<Date> iterator = navigableSet.descendingIterator();
			
			Set<Data> processedDataIterator = processedDatas.get(iterator.next());
			setValuesWeatherDay5(processedDataIterator);
			processedDataIterator = processedDatas.get(iterator.next());
			setValuesWeatherDay4(processedDataIterator);
			processedDataIterator = processedDatas.get(iterator.next());
			setValuesWeatherDay3(processedDataIterator);
			processedDataIterator = processedDatas.get(iterator.next());
			setValuesWeatherDay2(processedDataIterator);
			processedDataIterator = processedDatas.get(iterator.next());
			setValuesWeatherDay1(processedDataIterator);
			processedDataIterator = processedDatas.get(iterator.next());
			setValuesWeatherToday(localityToShow, processedDataIterator);

			viewSearcher.changePanelToData();
			uiFrame.refresh();

		}
	}


	

}
