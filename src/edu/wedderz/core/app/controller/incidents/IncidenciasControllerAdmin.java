package edu.wedderz.core.app.controller.incidents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.wedderz.core.app.view.incidents.IncidenciasAdmin;
import edu.wedderz.core.dataaccess.repo.impl.IncidentServiceImpl;
import edu.wedderz.core.dataaccess.repo.serv.IncidentService;
import edu.wedderz.core.model.Incident;

public class IncidenciasControllerAdmin implements ActionListener {

	IncidenciasAdmin incidencias;

	public IncidenciasControllerAdmin(IncidenciasAdmin incidencias) {

		this.incidencias = incidencias;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IncidentService incidentservice = new IncidentServiceImpl();

		switch (e.getActionCommand()) {

		case "buttonActualizar":
		

				mostrarTexto();

				incidentservice.getIncidentById(Integer.parseInt(incidencias.getComboBoxValue())).getSubject();
				
				incidencias.editorPaneAsunto.setText(incidentservice.getIncidentById(Integer.parseInt(incidencias.getComboBoxValue())).getSubject());
				incidencias.editorPaneDescripcion.setText(incidentservice.getIncidentById(Integer.parseInt(incidencias.getComboBoxValue())).getDescription());
			
				incidencias.setEditorTextAreaEstacion(String.valueOf(incidentservice.getIncidentById(Integer.parseInt(incidencias.getComboBoxValue())).getStation().getStationId()));
			break;
		case "buttonAceptar":

			
			 incidentservice.updateIncident(Integer.parseInt(incidencias.getComboBoxValue()), true);

			break;
		case "buttonDenegar":

			 incidentservice.updateIncident(Integer.parseInt(incidencias.getComboBoxValue()), false);

			break;
		
			
		}
	}

	public void mostrarTexto() {

		incidencias.editorPaneAsunto.setText("asunto");
		incidencias.editorPaneDescripcion.setText("Descripcion");
	}

}
