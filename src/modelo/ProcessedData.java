package modelo;

public class ProcessedData {
	
	Locality locality;
	//DataType dataType;
	//Timestamp time;
	double value;
	
	public ProcessedData(Locality locality/*, DataType dataType, Timestamp time*/, double value) {
		super();
		this.locality = locality;
		/*this.dataType = dataType;
		this.time = time;*/
		this.value = value;
	}

	public Locality getLocality() {
		return locality;
	}

	/*public DataType getDataType() {
		return dataType;
	}

	public Timestamp getTime() {
		return time;
	}*/

	public double getValue() {
		return value;
	}

}
