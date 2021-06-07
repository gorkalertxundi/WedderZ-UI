package edu.wedderz.core.app.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import edu.wedderz.core.model.Station;

public class StationListRenderer implements ListCellRenderer<Station> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Station> list, Station value, int index,
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		
		JPanel wrapper = new JPanel(new GridLayout(1, 1));
		JPanel panel = new JPanel(new GridLayout(1, 1));
		wrapper.add(panel);
		
		wrapper.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.setBorder(BorderFactory.createRaisedBevelBorder());
		//panel.setBackground((index % 2 == 0) ? Color.WHITE : Color.LIGHT_GRAY);
		
		JLabel idField = new JLabel(String.valueOf(value.getStationId() + " - " + value.getLocality().getName()));
		idField.setFont(new Font("system ui", Font.PLAIN, 12));
		panel.add(idField);
		return wrapper;
	}	

}
