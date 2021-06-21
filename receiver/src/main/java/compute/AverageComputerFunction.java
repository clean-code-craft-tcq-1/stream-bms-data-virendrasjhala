package compute;

import java.util.List;
import java.util.function.Function;

public class AverageComputerFunction implements IValidator,Function<List<Double>, Double> {

	@Override
	public Double apply(List<Double> paramValueList) {
		Double average = null;
		if (isNotNullOrEmpty(paramValueList)) {
			average = paramValueList.stream().mapToDouble(value -> value.doubleValue()).average().getAsDouble();
		}
		return average;
	}
	
	


}
