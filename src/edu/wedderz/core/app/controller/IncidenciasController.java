package edu.wedderz.core.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.wedderz.core.app.model.SearcherModel;
import edu.wedderz.core.app.view.BusquedaLocalidades;
import edu.wedderz.core.app.view.LocationSelectionPanel;
import edu.wedderz.core.app.view.UIFrame;
import edu.wedderz.core.app.view.Incidencias;

public class IncidenciasController implements ActionListener {

	
	 
	Incidencias incidencias;
	
	
	public IncidenciasController( Incidencias incidencias) {
		
		this.incidencias=incidencias;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "buttonEnviar") {
			
			
	
			
			String asuntoString =incidencias.getEditorPaneAsunto();
			String descripcionString = incidencias.getEditorPaneDescripcion();
			
			Boolean rdbtnCambio =  incidencias.getRdbtnCambio();
			Boolean RdbtnReembolso= incidencias.getRdbtnReembolso();
			
			if ((asuntoString.isEmpty() || descripcionString.isEmpty())) {
				if(rdbtnCambio || RdbtnReembolso ) {
				}else {
					JOptionPane.showMessageDialog(null,"Seleccione una opcion");

				}
				System.out.println("no pusiste nada");
				JOptionPane.showMessageDialog(null,"Rellena los dos campos ");
			}else {
				if(rdbtnCambio || RdbtnReembolso ) {
				}else {
					JOptionPane.showMessageDialog(null,"Seleccione una opcion");

				}
				JOptionPane.showMessageDialog(null,"Tu incidencia se ha mandado correctamente");

			}
			System.out.println("entra");
			
		} else {
			System.out.println("idiota");

		}

		// uiFrame.refresh();

	}



	
}
