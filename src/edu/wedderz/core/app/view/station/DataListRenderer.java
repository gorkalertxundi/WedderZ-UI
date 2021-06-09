package edu.wedderz.core.app.view.station;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.DateFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import edu.wedderz.core.model.Data;

public class DataListRenderer implements ListCellRenderer<Data> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Data> list, Data value, int index, boolean isSelected,
			boolean cellHasFocus) {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(8, 8, 8, 8)));
		panel.add(Box.createHorizontalGlue());
		panel.add(new JLabel(value.getDataType().getDescription() + ": " +  value.getValue() + " " + value.getDataType().getUnit()));
		panel.add(Box.createRigidArea(new Dimension(32, 0)));
		
		DateFormat f = DateFormat.getDateTimeInstance();
		panel.add(new JLabel(f.format(value.getDate())));
		panel.add(Box.createHorizontalGlue());
		return panel;
	}

}
