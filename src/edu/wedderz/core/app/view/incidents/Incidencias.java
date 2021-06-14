package edu.wedderz.core.app.view.incidents;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import edu.wedderz.core.app.controller.incidents.IncidenciasController2;
import edu.wedderz.core.dataaccess.repo.impl.StationServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.IncidentService;
import edu.wedderz.core.dataaccess.repo.serv.StationService;
import edu.wedderz.core.model.Station;
import edu.wedderz.core.model.User;



public class Incidencias extends JPanel  {
	
	Button buttonEnviar;
	JEditorPane editorPaneAsunto;

	JEditorPane editorPaneDescripcion;
	Boolean prueba; 
	private JComboBox<String> comboBoxEstaciones;
	
	StationService stationService = new StationServiceImpl();
	
	public Incidencias(Frame frame) {
		IncidenciasController2 incidenciascontroller;
		
		setBorder(new MatteBorder(20, 20, 20, 20, (Color) Color.WHITE));
		setLayout(new BorderLayout(0, 0));
		
		//asusnto
		editorPaneAsunto = new JEditorPane();
		editorPaneAsunto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPaneAsunto.setBackground(Color.LIGHT_GRAY);
		add(editorPaneAsunto, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE));
		add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		comboBoxEstaciones = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		panel.add(comboBoxEstaciones, gbc_comboBox);
		
		buttonEnviar = new Button("Enviar");
		buttonEnviar.setFont(new Font("Dialog", Font.PLAIN, 17));
		buttonEnviar.setActionCommand("buttonEnviar");
	
		IncidentService incidetservice;
		User u;
		for(Station s : stationService.getStationsOfUser(13)) {
			
			comboBoxEstaciones.addItem(String.valueOf(s.getStationId()));
			
		}
		//comboBoxEstaciones.addItem("28");
		//comboBoxEstaciones.addItem("29");
		//comboBoxEstaciones.addItem("30");
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 1;
		panel.add(buttonEnviar, gbc_button);
		//descripcion
		JPanel panelDescripcion = new JPanel();
		panelDescripcion.setBorder(new MatteBorder(10, 1, 1, 1, (Color) Color.WHITE));
		add(panelDescripcion, BorderLayout.CENTER);
		panelDescripcion.setLayout(new BoxLayout(panelDescripcion, BoxLayout.X_AXIS));
		
		
		editorPaneDescripcion = new JEditorPane();
		editorPaneDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPaneDescripcion.setBackground(Color.LIGHT_GRAY);
		panelDescripcion.add(editorPaneDescripcion);
		
		incidenciascontroller=new IncidenciasController2(this);
		setActionListener(incidenciascontroller);
		
		
		ButtonGroup bg=new ButtonGroup();
	}
	
	
	public void setActionListener(IncidenciasController2 incidenciascontroller2) {
		//buttonEnviar.setActionCommand("buttonEnviar");
		buttonEnviar.addActionListener(incidenciascontroller2);
			 
			}


	public String getEditorPaneAsunto() {
		return editorPaneAsunto.getText();
	}


	public String getEditorPaneDescripcion() {
		return editorPaneDescripcion.getText();
	}

	public String getcomboBoxEstacionesValue() {
		return comboBoxEstaciones.getSelectedItem().toString();
	}




	


}

