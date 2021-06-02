package edu.wedderz.core.app.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import edu.wedderz.core.app.view.UIFrame;

public class MiAction extends AbstractAction{

	public MiAction(String text, ImageIcon imageIcon, String descrip, int nemonic, UIFrame frame) {
		super(text, imageIcon);
		this.putValue(Action.SHORT_DESCRIPTION, descrip);
		this.putValue(Action.MNEMONIC_KEY, nemonic);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
