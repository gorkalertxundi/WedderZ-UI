package edu.wedderz.core.app.controller.incidents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.wedderz.core.app.view.incidents.Incidencias;
import edu.wedderz.core.dataaccess.repo.impl.IncidentServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.IncidentService;
import edu.wedderz.core.model.Incident;

public class IncidenciasController2 implements ActionListener {

	
	 
	Incidencias incidencias;
	
	
	public IncidenciasController2 (Incidencias incidencias) {
		
		this.incidencias=incidencias;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand() == "buttonEnviar") {
			
			
	
			
			String asuntoString =incidencias.getEditorPaneAsunto();
			String descripcionString = incidencias.getEditorPaneDescripcion();
			
			
			
			if ((asuntoString.isEmpty() || descripcionString.isEmpty())) {
				
				System.out.println("no pusiste nada");
				JOptionPane.showMessageDialog(null,"Rellena los dos campos ");
			}else {
				
				IncidentService incidentservice =new IncidentServiceImpl() ;


				

				
				
				Incident i = incidentservice.createIncident(Integer.parseInt(incidencias.getcomboBoxEstacionesValue()),asuntoString,descripcionString);
						
						
				System.out.println(i.getDescription());
				
				
				JOptionPane.showMessageDialog(null,"Tu incidencia se ha mandado correctamente");

			}
			System.out.println("entra");
			
		} else {
			System.out.println("idiota");

		}

		// uiFrame.refresh();

	}



	
}
