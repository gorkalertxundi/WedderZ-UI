package edu.wedderz.core.app.view.station;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.wedderz.core.app.controller.station.StationDataListController;
import edu.wedderz.core.model.Data;

public class StationDataList extends JPanel {
	
	private JList<Data> dataList;
	private DefaultListModel<Data> dataListModel;
	private Map<String, JButton> buttons;
	private StationDataListController stationDataListController;
	
	public StationDataList(StationDataListController stationDataListController) {
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		dataList = new JList<>();
		dataListModel = new DefaultListModel<>();
		dataList.setModel(dataListModel);
		dataList.setCellRenderer(new DataListRenderer());
		
		this.add(Box.createVerticalGlue());
		
		JLabel headerLabel = new JLabel("Most recent data collected by the station:");
		headerLabel.setAlignmentX(LEFT_ALIGNMENT);
		headerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		JPanel headerWrapper = new JPanel(new GridLayout());
		headerWrapper.setBackground(Color.WHITE);
		headerWrapper.add(headerLabel);
		headerWrapper.setMaximumSize(new Dimension(headerWrapper.getMaximumSize().width, 32));
		headerWrapper.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
		
		this.add(headerWrapper);
		
		JScrollPane listPane = new JScrollPane(dataList);
		listPane.setBackground(Color.WHITE);
		this.add(listPane);
		this.add(Box.createRigidArea(new Dimension(0, 32)));
		
		JPanel filterButtonsPanel = new JPanel();
		filterButtonsPanel.setLayout(new BoxLayout(filterButtonsPanel, BoxLayout.LINE_AXIS));
		filterButtonsPanel.setBackground(Color.WHITE);
		
		buttons = new HashMap<>();
		
		for(String f : stationDataListController.getFilterList()) buttons.put(f, new JButton());
		
		JLabel filterByLabel = new JLabel("Filter data by type: ");
		filterByLabel.setBackground(Color.WHITE);
		filterButtonsPanel.add(filterByLabel);
		JButton noFilterButton = new JButton();
		noFilterButton.setText("Show all");
		noFilterButton.setActionCommand("SHOW_ALL");
		noFilterButton.addActionListener(stationDataListController);
		noFilterButton.setEnabled(false);
		filterButtonsPanel.add(noFilterButton);
		
		for(String k : buttons.keySet()) {
			JButton button = buttons.get(k);
			button.setText(k);
			button.setActionCommand(k);
			button.addActionListener(stationDataListController);
			button.setEnabled(false);
			filterButtonsPanel.add(button);
		}
		
		buttons.put("SHOW_ALL", noFilterButton);
		this.add(filterButtonsPanel);
		this.add(Box.createVerticalGlue());
		
	}
	
	public void setDataList(Collection<Data> dataSet) {
		dataListModel.removeAllElements();
		dataListModel.addAll(dataSet);
	}
	
	public void enableButtons(Collection<String> keys) {
		for(String k : keys) buttons.get(k).setEnabled(true);
		buttons.get("SHOW_ALL").setEnabled(true);
	}
	
	public void disableButton(String key) {
		buttons.get(key).setEnabled(false);
	}
	
}
