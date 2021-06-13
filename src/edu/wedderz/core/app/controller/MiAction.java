package edu.wedderz.core.app.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import edu.wedderz.core.app.controller.station.admin.AdminStationListController;
import edu.wedderz.core.app.controller.station.user.UserStationListController;
import edu.wedderz.core.app.view.UIFrame;
import edu.wedderz.core.app.view.incidents.Incidencias;
import edu.wedderz.core.app.view.incidents.IncidenciasAdmin;
import edu.wedderz.core.app.view.search.BusquedaLocalidades;
import edu.wedderz.core.app.view.shop.ShopPanel;
import edu.wedderz.core.dataaccess.repo.impl.UserServiceImpl;

public class MiAction extends AbstractAction {

	String command;
	UIFrame frame;
	
	public MiAction(String text, ImageIcon imageIcon, String descrip, int nemonic, UIFrame frame) {
		super(text, imageIcon);
		this.command = text;
		this.frame = frame;
		this.putValue(Action.SHORT_DESCRIPTION, descrip);
		this.putValue(Action.MNEMONIC_KEY, nemonic);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (command) {
		case "Search locality":
			frame.setPanel(new BusquedaLocalidades(frame));
			break;
		case "Log out":
			break;
		case "Log in":
			break;
		case "My stations":
			frame.setPanel(new UserStationListController(frame, new UserServiceImpl().getUserById(13)).getUserStationListView());
			break;
			
		case "Administrate stations":
			frame.setPanel(new AdminStationListController(frame).getAdminStationListView());
			break;
		case "My incidences":
			if(true) {
				frame.setPanel(new IncidenciasAdmin(frame));
			}
			else {
				frame.setPanel(new Incidencias(frame));
			}
			
			break;
		case "Purchase stations":
			frame.setPanel(new ShopPanel());
			break;
		default:
			break;
		}
		
	}

}
