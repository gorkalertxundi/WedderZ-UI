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

	Set<Data> generalSet;
	Map<DataType, List<Data>> dataSets;
	
	StationDataList dataList;
	
	public StationDataListController() {
		dataList = new StationDataList();
	}
	
	public void setDataList(Collection<Data> dataSet) {
		dataList.setDataList(dataSet);
		dataSets = generalSet.stream().collect(Collectors.groupingBy(Data::getDataType));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		
		Set<DataType> keys = dataSets.keySet();
		DataType t = null;
		for(DataType k : keys) if(k.getDescription().equals(ac)) t = k;
		if(dataSets.containsKey(t)) setDataList(dataSets.get(t));
	}
}
