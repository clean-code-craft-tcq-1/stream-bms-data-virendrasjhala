package battery;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.mockito.Mockito;

import compute.AverageComputerFunction;
import compute.MaximumComputerFunction;
import compute.MinimumComputerFunction;

/**
 * Test class for Battery param receiver
 */
public class BatteryParamReceiverTest {

	@Test
	public void givenValuesComputeMin_VerifyOutput() {
		MinimumComputerFunction minCompFunction = new MinimumComputerFunction();
		Double minValue = minCompFunction.apply(getValueList());
		org.junit.Assert.assertTrue(minValue.doubleValue() == 0.2);
	}

	@Test
	public void givenValuesComputeMinForEmptyList() {
		MinimumComputerFunction minCompFunction = new MinimumComputerFunction();
		Double min = minCompFunction.apply(new ArrayList<>());
		org.junit.Assert.assertNull(min);
	}

	@Test
	public void givenValuesComputeMinForNullList() {
		MinimumComputerFunction minCompFunction = new MinimumComputerFunction();
		Double min = minCompFunction.apply(null);
		org.junit.Assert.assertNull(min);
	}

	@Test
	public void givenValuesComputeMax_VerifyOutput() {
		MaximumComputerFunction maxCompFunction = new MaximumComputerFunction();
		Double maxValue = maxCompFunction.apply(getValueList());
		org.junit.Assert.assertTrue(maxValue.doubleValue() == 21.0);
	}

	@Test
	public void givenValuesComputeMaxForEmptyList() {
		MaximumComputerFunction maxCompFunction = new MaximumComputerFunction();
		Double max = maxCompFunction.apply(new ArrayList<>());
		org.junit.Assert.assertNull(max);
	}

	@Test
	public void givenValuesComputeMaxForNullList() {
		MaximumComputerFunction maxCompFunction = new MaximumComputerFunction();
		Double max = maxCompFunction.apply(null);
		org.junit.Assert.assertNull(max);
	}

	@Test
	public void givenValuesComputeAverageVerifyOutput() {
		AverageComputerFunction avgCompFunction = new AverageComputerFunction();
		Double avg = avgCompFunction.apply(getValueList());
		org.junit.Assert.assertTrue(avg.doubleValue() == 7.216666666666666);
	}

	@Test
	public void givenValuesComputeAverageForEmptyList() {
		AverageComputerFunction avgCompFunction = new AverageComputerFunction();
		Double avg = avgCompFunction.apply(new ArrayList<>());
		org.junit.Assert.assertNull(avg);
	}

	@Test
	public void givenValuesComputeAverageForNullList() {
		AverageComputerFunction avgCompFunction = new AverageComputerFunction();
		Double avg = avgCompFunction.apply(null);
		org.junit.Assert.assertNull(avg);
	}

	@Test
	public void testReadAndCompute() throws Exception {
		Scanner scanner= new Scanner(new File("resources/inputFile.txt"));
		BatteryParamReceiver receiverSpy = Mockito.spy(new BatteryParamReceiver());
		receiverSpy.readAndCompute(scanner);
		Mockito.verify(receiverSpy,Mockito.times(1)).readAndCompute(scanner);
		Mockito.verify(receiverSpy,Mockito.times(46)).computeAndPrintMin();
		Mockito.verify(receiverSpy,Mockito.times(46)).computeAndPrintMax();
		Mockito.verify(receiverSpy,Mockito.times(9)).computeAndPrintAverage();
	}

	private List<Double> getValueList() {
		List<Double> valueList = new ArrayList<>();
		valueList.add(5.1);
		valueList.add(10.0);
		valueList.add(0.2);
		valueList.add(3.0);
		valueList.add(21.0);
		valueList.add(4.0);
		return valueList;
	}

}
