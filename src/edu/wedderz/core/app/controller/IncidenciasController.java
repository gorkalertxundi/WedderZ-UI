package edu.wedderz.core.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.wedderz.core.app.model.SearcherModel;
import edu.wedderz.core.app.view.BusquedaLocalidades;
import edu.wedderz.core.app.view.LocationSelectionPanel;
import edu.wedderz.core.app.view.ShopPanel;
import edu.wedderz.core.app.view.UIFrame;
import edu.wedderz.core.app.view.IncidenciasAdmin;

public class IncidenciasController implements ActionListener {

	
	 
	IncidenciasAdmin incidencias;
	
	
	public IncidenciasController( IncidenciasAdmin incidencias) {
		
		this.incidencias=incidencias;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "buttonEnviar":
	
				String asuntoString =incidencias.getEditorPaneAsunto();
				String descripcionString = incidencias.getEditorPaneDescripcion();
				JEditorPane asunto = null;
				asunto.setText("asunto");
				JEditorPane descripcion = null;
				descripcion.setText("descripcion");
				
						
				
				if ((asuntoString.isEmpty() || descripcionString.isEmpty())) {
					
					System.out.println("no pusiste nada");
					JOptionPane.showMessageDialog(null,"Rellena los dos campos ");
					
				}else {
					
					JOptionPane.showMessageDialog(null,"Tu incidencia se ha mandado correctamente");
	
				}
				System.out.println("entra");
				
				
				
				break;
			case "buttonActualizar":
				if(incidencias.getComboBoxValue().equals("dos")) {
					incidencias.editorPaneAsunto.setText("asunto");
					incidencias.editorPaneDescripcion.setText("Descripcion");
				}else {
					incidencias.editorPaneAsunto.setText("");
					incidencias.editorPaneDescripcion.setText("");
				}
				
				break;
			case "Iniciar sesión":
				break;
			case "Mis estaciones":
				break;
			case "Mis Incidencias":
				
				
				
				break;
			case "Comprar estaciones":
				
				break;
			default:
				break;
			}
		}
	}
	
	
	
	
	
	
	


