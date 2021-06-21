/**
 * 
 */
package battery;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to hold battery parameter values
 */
public class BatteryParameter {

	private List<Double> batteryParamValue1List = new ArrayList<>();
	
	private List<Double> batteryParamValue2List = new ArrayList<>();

	public List<Double> getBatteryParamValue1List() {
		return batteryParamValue1List;
	}

	public void setBatteryParamValue1List(List<Double> batteryParamValue1List) {
		this.batteryParamValue1List = batteryParamValue1List;
	}

	public List<Double> getBatteryParamValue2List() {
		return batteryParamValue2List;
	}

	public void setBatteryParamValue2List(List<Double> batteryParamValue2List) {
		this.batteryParamValue2List = batteryParamValue2List;
	}



}
