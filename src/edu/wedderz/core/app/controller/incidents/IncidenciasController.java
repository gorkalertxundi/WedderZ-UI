package edu.wedderz.core.app.controller.incidents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;

import edu.wedderz.core.app.view.incidents.IncidenciasAdmin;

public class IncidenciasController implements ActionListener {

	
	 
	IncidenciasAdmin incidencias;
	
	
	public IncidenciasController (IncidenciasAdmin incidencias) {
		
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
					
					mostrarTexto();
					
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
	
public void mostrarTexto() {
	incidencias.editorPaneAsunto.setText("asunto");
	incidencias.editorPaneDescripcion.setText("Descripcion");
	}


	}
	
	
	
	
	
	
	


