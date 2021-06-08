package edu.wedderz.core.app.view.station;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

import edu.wedderz.core.model.Data;

public class StationDataList extends JPanel {
	
	JList<Data> dataList;
	ListModel<Data> dataListModel;
	
	public StationDataList() {
		this.setBackground(Color.BLUE);
		dataList = new JList<>();
		dataListModel = new DefaultListModel<>();
		dataList.setModel(dataListModel);
		dataList.setCellRenderer(new DataListRenderer());
		this.add(dataList);
	}
	
}
