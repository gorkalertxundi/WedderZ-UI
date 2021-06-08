package edu.wedderz.core.app.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import edu.wedderz.core.app.view.BusquedaLocalidades;
import edu.wedderz.core.app.view.IncidenciasAdmin;
import edu.wedderz.core.app.view.ShopPanel;
import edu.wedderz.core.app.view.UIFrame;

public class MiAction extends AbstractAction{

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
		case "Buscar localidad":
			frame.setPanel(new BusquedaLocalidades(frame));
			break;
		case "Cerrar sesión":
			break;
		case "Iniciar sesión":
			break;
		case "Mis estaciones":
			break;
		case "Mis Incidencias":
			System.out.println("blabla");
			frame.setPanel(new IncidenciasAdmin(frame));
			
			break;
		case "Comprar estaciones":
			frame.setPanel(new ShopPanel()); //
			break;
		default:
			break;
		}
		
	}

}
