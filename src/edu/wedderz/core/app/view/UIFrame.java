package edu.wedderz.core.app.view;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import edu.wedderz.core.app.controller.MiAction;
import edu.wedderz.core.app.controller.station.user.UserStationListController;
import edu.wedderz.core.dataaccess.repo.impl.UserServiceImpl;
import edu.wedderz.core.model.User;

public class UIFrame extends JFrame {
	
	AbstractAction search, close, open, stations, incidents, buy;

	public UIFrame() {
		this.setSize(new Dimension(1280,720)); //PC
		//this.setSize(new Dimension(750,1334)); //Movil
		this.setTitle("WedderZ");
		this.setIconImage(new ImageIcon("icons/logo.png").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initialiciteAction();
		this.setJMenuBar(createMenuBar());
		this.setContentPane(new UserStationListController(this, new UserServiceImpl().getUserById(13)).getUserStationListView());
		this.setVisible(true);
	}
	
	private void initialiciteAction() {
		search = new MiAction("Search locality", new ImageIcon(), "Buscar", KeyEvent.VK_B, this);
		close = new MiAction("Log out", new ImageIcon(), "Cerrar", KeyEvent.VK_C, this);
		open = new MiAction("Log in", new ImageIcon(), "Iniciar", KeyEvent.VK_I, this);
		stations = new MiAction("My stations", new ImageIcon(), "Estaciones", KeyEvent.VK_M, this);
		incidents = new MiAction("My incidences", new ImageIcon(), "Incidencias", KeyEvent.VK_I, this);
		buy = new MiAction("Purchase stations", new ImageIcon(), "Compras", KeyEvent.VK_E, this);
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar bar = new JMenuBar();
		bar.add(createMenuSearch());
		bar.add(createMenuShops());
		bar.add(createMenuIncidents());
		bar.add(createMenuStations());
		bar.add(createMenuSession());

		return bar;
	}

	private JMenu createMenuStations() {
		JMenu menu = new JMenu("Stations");
		menu.setMnemonic(KeyEvent.VK_E);
		
		menu.add(stations);
		
		return menu;	
	}

	private JMenu createMenuSession() {
		JMenu menu = new JMenu("Session");
		menu.setMnemonic(KeyEvent.VK_B);
		
		menu.add(close);
		menu.add(open);
		
		return menu;	
	}

	private JMenu createMenuIncidents() {
		JMenu menu = new JMenu("Incidences");
		menu.setMnemonic(KeyEvent.VK_B);
		
		menu.add(incidents);
		
		return menu;	
		
	}

	private JMenu createMenuShops() {
		JMenu menu = new JMenu("Store");
		menu.setMnemonic(KeyEvent.VK_B);
		
		menu.add(buy);
		
		return menu;
	}

	private JMenu createMenuSearch() {
		JMenu menu = new JMenu("Search");
		menu.setMnemonic(KeyEvent.VK_B);
		
		menu.add(search);
		
		return menu;
	}
	
	public void refresh() {
        this.invalidate();
        this.validate();
        this.repaint();
    }

	public static void main(String[] args) {
		UIFrame frameTMP = new UIFrame();

	}
	
}
