package vista;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import controlador.MiAction;

public class Frame extends JFrame {
	
	AbstractAction search;

	public Frame() {
		this.setSize(new Dimension(1280,720)); //PC
		//this.setSize(new Dimension(750,1334)); //Movil
		this.setTitle("WedderZ");
		this.setIconImage(new ImageIcon("icons/logo.png").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initialiciteAction();
		this.setJMenuBar(createMenuBar());
		this.setContentPane(new BusquedaLocalidades());
		this.setVisible(true);
	}
	
	private void initialiciteAction() {
		search = new MiAction("añadir", new ImageIcon(), "añadir", KeyEvent.VK_P, this);
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar bar = new JMenuBar();
		bar.add(createMenuSearch());
		return bar;
	}

	private JMenu createMenuSearch() {
		JMenu menu = new JMenu("Salir");
		menu.setMnemonic(KeyEvent.VK_S);
		
		menu.add(search);
		
		return menu;
	}

	public static void main(String[] args) {
		Frame frameTMP = new Frame();

	}
	
}
