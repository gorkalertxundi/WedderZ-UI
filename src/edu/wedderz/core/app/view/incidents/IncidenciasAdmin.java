package edu.wedderz.core.app.view.incidents;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import edu.wedderz.core.app.controller.incidents.IncidenciasController;
import edu.wedderz.core.app.view.UIFrame;



public class IncidenciasAdmin extends JPanel  {

	
	
	Button buttonDenegar;
	public JEditorPane editorPaneAsunto;

	public JEditorPane editorPaneDescripcion;
	Boolean prueba; 
	Button buttonAceptar;
	JComboBox comboBox;
	 Button buttonActualizar;
	 private JTextArea textAreaEstacion;
	
	public IncidenciasAdmin(UIFrame uiFrame) {
		Incidencias incidencias = null;
		IncidenciasController incidenciascontroller;
		
		setBorder(new MatteBorder(20, 20, 20, 20, (Color) Color.WHITE));
		setLayout(new BorderLayout(0, 0));
		
		//asusnto
		 editorPaneAsunto = new JEditorPane();
		 editorPaneAsunto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPaneAsunto.setBackground(Color.LIGHT_GRAY);
		add(editorPaneAsunto, BorderLayout.NORTH);
		editorPaneAsunto.setBorder(BorderFactory.createTitledBorder("Asunto"));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE));
		add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		textAreaEstacion = new JTextArea();
		textAreaEstacion.setBackground(SystemColor.inactiveCaptionBorder);
		textAreaEstacion.setEnabled(false);
		textAreaEstacion.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		panel.add(textAreaEstacion, gbc_textArea);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		addIncidencias(comboBox);

		
		
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);
		
		buttonAceptar = new Button("Aceptar");
		buttonAceptar.setFont(new Font("Dialog", Font.PLAIN, 17));
		GridBagConstraints gbc_buttonAceptar = new GridBagConstraints();
		gbc_buttonAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAceptar.gridx = 0;
		gbc_buttonAceptar.gridy = 2;
		panel.add(buttonAceptar, gbc_buttonAceptar);
		//descripcion
		JPanel panelDescripcion = new JPanel();
		panelDescripcion.setBorder(new MatteBorder(10, 1, 1, 1, (Color) Color.WHITE));
		add(panelDescripcion, BorderLayout.CENTER);
		panelDescripcion.setLayout(new BoxLayout(panelDescripcion, BoxLayout.X_AXIS));
		
		
		editorPaneDescripcion = new JEditorPane();
		editorPaneDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPaneDescripcion.setBackground(Color.LIGHT_GRAY);
		panelDescripcion.add(editorPaneDescripcion);
		editorPaneDescripcion.setBorder(BorderFactory.createTitledBorder("Descripcion"));

		
		
		
		
		
		
		buttonActualizar = new Button("Actualizar");
		buttonActualizar.setFont(new Font("Dialog", Font.PLAIN, 17));
		buttonActualizar.setActionCommand("buttonActualizar");
		GridBagConstraints gbc_buttonActualizar = new GridBagConstraints();
		gbc_buttonActualizar.insets = new Insets(0, 0, 5, 5);
		gbc_buttonActualizar.gridx = 1;
		gbc_buttonActualizar.gridy = 2;
		panel.add(buttonActualizar, gbc_buttonActualizar);
		
		buttonDenegar = new Button("Denegar");
		buttonDenegar.setFont(new Font("Dialog", Font.PLAIN, 17));
		buttonDenegar.setActionCommand("buttonDenegar");
		
		
		
			
			
			GridBagConstraints gbc_button_11 = new GridBagConstraints();
			gbc_button_11.insets = new Insets(0, 0, 5, 0);
			gbc_button_11.gridx = 2;
			gbc_button_11.gridy = 2;
			panel.add(buttonDenegar, gbc_button_11);
			
	
			
			
			incidenciascontroller=new IncidenciasController(this,true,incidencias);
			setActionListener(incidenciascontroller);
			
			buttonDenegar.addActionListener(incidenciascontroller);
			buttonAceptar.addActionListener(incidenciascontroller);
			buttonActualizar.addActionListener(incidenciascontroller);

	}
	
	
	public void setActionListener(IncidenciasController incidenciascontroller) {
		//buttonEnviar.setActionCommand("buttonEnviar");
		buttonDenegar.addActionListener(incidenciascontroller);
			 
			}


	public String getEditorPaneAsunto() {
		return editorPaneAsunto.getText();
	}


	public String getEditorPaneDescripcion() {
		return editorPaneDescripcion.getText();
	}

	public void addIncidencias(JComboBox comboBox) {
		
		comboBox.addItem("uno");
		comboBox.addItem("dos");
		comboBox.addItem("tres");
	}


	public void setEditorPaneAsunto(JEditorPane editorPaneAsunto) {
		this.editorPaneAsunto = editorPaneAsunto;
	}


	public void setEditorPaneDescripcion(JEditorPane editorPaneDescripcion) {
		this.editorPaneDescripcion = editorPaneDescripcion;
	}


	public String getComboBoxValue() {
		return comboBox.getSelectedItem().toString();
	}


	

	
	
	
}