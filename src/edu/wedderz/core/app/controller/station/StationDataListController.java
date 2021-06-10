package edu.wedderz.core.app.controller.station;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import edu.wedderz.core.app.view.station.StationDataList;
import edu.wedderz.core.model.Data;
import edu.wedderz.core.model.DataType;

public class StationDataListController implements ActionListener {

	private final String[] FILTER_LIST = { "Temperature", "Pressure", "Humidity", "Wind speed", "UV index" };

	private Collection<Data> generalSet;
	private Map<DataType, List<Data>> dataSets;

	private StationDataList dataList;

	private DataType previousFilter = null;

	public StationDataListController() {
		dataList = new StationDataList(this);
	}

	public void setDataList(Collection<Data> dataSet) {
		generalSet = dataSet;
		dataList.setDataList(generalSet);
		dataSets = generalSet.stream().collect(Collectors.groupingBy(Data::getDataType));
		dataList.enableButtons(dataSets.keySet().stream().map(DataType::getDescription).collect(Collectors.toList()));
		dataList.disableButton("SHOW_ALL");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();

		switch (ac) {

		case "SHOW_ALL":
			dataList.setDataList(generalSet);
			dataList.disableButton(ac);
			break;

		default:
			Set<DataType> keys = dataSets.keySet();
			DataType t = null;
			for (DataType k : keys) {
				if (k.getDescription().equals(ac))
					t = k;
			}
			if (dataSets.containsKey(t)) {
				dataList.setDataList(dataSets.get(t));
			}
			break;

		}

		dataList.enableButtons(dataSets.keySet().stream().map(DataType::getDescription).collect(Collectors.toList()));
		dataList.disableButton(ac);

	}

	public String[] getFilterList() {
		return FILTER_LIST;
	}

	public StationDataList getStationDataList() {
		return dataList;
	}
}
