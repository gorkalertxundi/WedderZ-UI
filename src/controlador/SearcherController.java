package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;

import edu.wedderz.dataaccess.model.Locality;
import edu.wedderz.dataaccess.model.ProcessedData;
import modelo.SearcherModel;
import vista.BusquedaLocalidades;
import vista.LocationSelectionPanel;
import vista.UIFrame;
import vista.WeatherPanel;

public class SearcherController implements ActionListener{
	
	String searchField;
	SearcherModel model;
	BusquedaLocalidades viewSearcher;
	WeatherPanel weatherPanel;
	UIFrame uiFrame;
	LocationSelectionPanel locationSelectionPanel;
	
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
	private void setValuesWeather(ProcessedData processedData) {
		weatherPanel.setCurrentWeatherValues(processedData.getLocality().getName(), "ES", 5, 10, 8, 15, 1018.3, 66, 3.47);
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
			//buscar localidad en la datu basea
			//y luego coger los datos
			
			ArrayList<Locality> localities = model.getLocality(textString);
			if(textString.equals("")) {
				viewSearcher.changePanelToNotFound();
			}
			else {
				locationSelectionPanel.putLocalities(localities);
				viewSearcher.changePanelToSelection();
			}
			uiFrame.refresh();
		
		}
		else if(e.getActionCommand() == "Selection") {
			JComboBox<String> comboBox = (JComboBox<String>) locationSelectionPanel.getComboBox();
			String localidadNombre = (String) comboBox.getSelectedItem();

			ProcessedData processedData = model.getProcessedData(new Locality(1, localidadNombre, 5.5, 5.5));
			viewSearcher.changePanelToData();
			setValuesWeather(processedData);
			uiFrame.refresh();

		}
	}


	

}
