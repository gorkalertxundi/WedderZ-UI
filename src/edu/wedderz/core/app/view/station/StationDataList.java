package edu.wedderz.core.app.view.station;

import java.awt.Color;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import edu.wedderz.core.model.Data;

public class StationDataList extends JScrollPane {
	
	JList<Data> dataList;
	DefaultListModel<Data> dataListModel;
	
	public StationDataList() {
		this.setBackground(Color.BLUE);
		dataList = new JList<>();
		dataListModel = new DefaultListModel<>();
		dataList.setModel(dataListModel);
		dataList.setCellRenderer(new DataListRenderer());
		this.setViewportView(dataList);
	}
	
	public void setDataList(Collection<Data> dataSet) {
		dataListModel.removeAllElements();
		dataListModel.addAll(dataSet);
	}
	
}
