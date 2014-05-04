package edu.esprit.banque.webJSF.mb;



import java.io.Serializable;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

public class MapBean implements Serializable {

	private MapModel simpleModel;

	public MapBean() {
		simpleModel = new DefaultMapModel();
		
		//Shared coordinates
		LatLng coord1 = new LatLng(36.8995269, 10.1893424);
		
	
		
		//Basic marker
		simpleModel.addOverlay(new Marker(coord1, "ESPRIT"));
		
	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}
}
					