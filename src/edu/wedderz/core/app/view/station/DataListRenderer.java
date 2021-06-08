package edu.wedderz.core.app.view.station;

import java.awt.Component;

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
		panel.add(Box.createHorizontalGlue());
		panel.add(new JLabel(value.getDataType().getDescription() + ": " +  value.getValue() + " " + value.getDataType().getUnit()));
		panel.add(Box.createHorizontalGlue());
		return panel;
	}

}
