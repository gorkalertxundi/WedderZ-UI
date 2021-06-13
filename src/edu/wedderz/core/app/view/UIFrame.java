package edu.wedderz.core.app.view;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.wedderz.core.app.controller.MiAction;
import edu.wedderz.core.app.controller.station.user.UserStationListController;
import edu.wedderz.core.app.view.search.BusquedaLocalidades;
import edu.wedderz.core.dataaccess.repo.impl.UserServiceImpl;

public class UIFrame extends JFrame {
	
	AbstractAction search, close, open, userStations, adminStations, incidents, buy;

	public UIFrame() {
		this.setSize(new Dimension(1280,760)); //PC
		//this.setSize(new Dimension(750,1334)); //Movil
		this.setTitle("WedderZ");
		this.setIconImage(new ImageIcon("icons/logo.png").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initialiciteAction();
		this.setJMenuBar(createMenuBar());
		this.setContentPane(new BusquedaLocalidades(this));
		this.setVisible(true);
	}
	
	private void initialiciteAction() {
		search = new MiAction("Search locality", new ImageIcon(), "Search locality", KeyEvent.VK_B, this);
		close = new MiAction("Log out", new ImageIcon(), "Log out", KeyEvent.VK_C, this);
		open = new MiAction("Log in", new ImageIcon(), "Log in", KeyEvent.VK_I, this);
		userStations = new MiAction("My stations", new ImageIcon(), "My stations", KeyEvent.VK_M, this);
		adminStations = new MiAction("Administrate stations", new ImageIcon(), "Administrate stations", KeyEvent.VK_M, this);
		incidents = new MiAction("My incidences", new ImageIcon(), "My incidences", KeyEvent.VK_I, this);
		buy = new MiAction("Purchase stations", new ImageIcon(), "Purchase stations", KeyEvent.VK_E, this);
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
		
		menu.add(userStations);
		menu.add(adminStations);
		
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
	
	public void setPanel(JPanel panel) {
		this.setContentPane(panel);
		refresh();
	}
	
	public void refresh() {
        this.invalidate();
        this.validate();
        this.repaint();
    }

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		UIFrame frameTMP = new UIFrame();

	}
	
}
