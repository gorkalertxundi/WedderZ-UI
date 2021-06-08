package edu.wedderz.core.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import edu.wedderz.core.app.controller.IncidenciasController;
import edu.wedderz.core.app.controller.SearcherController;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Checkbox;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;


public class Incidencias extends JPanel  {
	
	Button buttonEnviar;
	JEditorPane editorPaneAsunto;

	JEditorPane editorPaneDescripcion;
	Boolean prueba; 
	public Incidencias() {
		IncidenciasController incidenciascontroller;
		
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
		
		buttonEnviar = new Button("Enviar");
		buttonEnviar.setFont(new Font("Dialog", Font.PLAIN, 17));
		buttonEnviar.setActionCommand("buttonEnviar");
	
		
		
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
		
		incidenciascontroller=new IncidenciasController(this);
		setActionListener(incidenciascontroller);
		
		ButtonGroup bg=new ButtonGroup();
	}
	
	
	public void setActionListener(IncidenciasController incidenciascontroller) {
		//buttonEnviar.setActionCommand("buttonEnviar");
		buttonEnviar.addActionListener(incidenciascontroller);
			 
			}


	public String getEditorPaneAsunto() {
		return editorPaneAsunto.getText();
	}


	public String getEditorPaneDescripcion() {
		return editorPaneDescripcion.getText();
	}





	


}

