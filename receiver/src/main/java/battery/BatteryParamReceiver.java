package battery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import compute.AverageComputerFunction;
import compute.MaximumComputerFunction;
import compute.MinimumComputerFunction;

public class BatteryParamReceiver {

	private BatteryParameter batteryParam = new BatteryParameter();
	
	private MinimumComputerFunction minFunction=new MinimumComputerFunction();
	
	private MaximumComputerFunction maxFunction = new MaximumComputerFunction();
	
	private AverageComputerFunction avgFunction = new AverageComputerFunction();
	
	public void readAndCompute(Scanner scanner) throws Exception {

		try {
			String inputParam = null;
			int counter = 0;
			while (scanner.hasNext()) {
				inputParam = scanner.nextLine();
				
				validateInput(inputParam);
				
				addToModel(inputParam.split("\\s"));
				
				counter++;
				
				computeAndPrintMin();

				computeAndPrintMax();

				// compute moving average after reading 5 inputs
				if (counter % 5 == 0) {
					computeAndPrintAverage();
				}

			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		finally {
			scanner.close();
		}
	}

	private void validateInput(String input) throws Exception {
		if (input == null || input.isEmpty()) {
			throw new Exception("Invalid input.");
		}
	}

	public void addToModel(String[] inputValueString) {
		batteryParam.getBatteryParamValue1List().add(Double.valueOf(inputValueString[0]));
		batteryParam.getBatteryParamValue2List().add(Double.valueOf(inputValueString[1]));
	}

	public void computeAndPrintMin() {
		Double minValueForParam1 = minFunction.apply(batteryParam.getBatteryParamValue1List());
		Double minValueForParam2 = minFunction.apply(batteryParam.getBatteryParamValue2List());
		System.out.println("Minimum : "+minValueForParam1 + " - "+minValueForParam2);
	}

	public void computeAndPrintMax() {
		Double maxValueForParam1 = maxFunction.apply(batteryParam.getBatteryParamValue1List());
		Double maxValueForParam2 = maxFunction.apply(batteryParam.getBatteryParamValue2List());
		System.out.println("Maximum : "+maxValueForParam1 + " - " + maxValueForParam2);
	}

	public void computeAndPrintAverage() {
		List<Double> lastFiveParamValue1List = getLastFiveParamValues(batteryParam.getBatteryParamValue1List());
		List<Double> lastFiveParamValue2List = getLastFiveParamValues(batteryParam.getBatteryParamValue2List());
		Double avgValueForParam1 = avgFunction.apply(lastFiveParamValue1List);
		Double avgValueForParam2 = avgFunction.apply(lastFiveParamValue2List);
		System.out.println("Average : "+avgValueForParam1 + " - " + avgValueForParam2);
	}

	public List<Double> getLastFiveParamValues(List<Double> paramValueList) {
		List<Double> lastFiveParamValueList = new ArrayList<>();
		int lastElementIndex = paramValueList.size()-1;
		for (int i = lastElementIndex; i > (lastElementIndex - 5); i--) {
			lastFiveParamValueList.add(paramValueList.get(i));
		}
		return lastFiveParamValueList;
	}

}
