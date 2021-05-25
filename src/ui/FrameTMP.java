package ui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class FrameTMP extends JFrame{


	public FrameTMP() {
		this.setSize(new Dimension(1280,720)); //PC
		//this.setSize(new Dimension(750,1334)); //Movil
		this.setTitle("WedderZ");
		this.setIconImage(new ImageIcon("icons/logo.png").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new WeatherPanel());
		this.setVisible(true);
	}


	public static void main(String[] args) {
		FrameTMP frameTMP = new FrameTMP();

	}

}
