package edu.wedderz.core.app.view;

import javax.swing.JPanel;
import java.awt.Scrollbar;
import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JMenuItem;
import java.awt.Canvas;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;
import javax.swing.JList;

public class IncidenciasAdmin extends JPanel  {

	
	
	

	public IncidenciasAdmin(UIFrame uiFrame) {
		setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		list.setBackground(Color.RED);
		add(list, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JEditorPane dtrpnAsunto = new JEditorPane();
		dtrpnAsunto.setText("Asunto");
		panel.add(dtrpnAsunto, BorderLayout.NORTH);
		
		JEditorPane editorPane = new JEditorPane();
		panel.add(editorPane, BorderLayout.CENTER);
		
		
		
	}
	
	
	
	
	
	
	
	
}
