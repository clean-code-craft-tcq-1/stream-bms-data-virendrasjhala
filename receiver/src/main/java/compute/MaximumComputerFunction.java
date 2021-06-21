package compute;

import java.util.List;
import java.util.function.Function;

public class MaximumComputerFunction implements IValidator,Function<List<Double>, Double> {
	
	@Override
	public Double apply(List<Double> paramValueList) {
		Double max = null;
		if (isNotNullOrEmpty(paramValueList)) {
			max = paramValueList.stream().mapToDouble(value -> value.doubleValue()).max().getAsDouble();
		}
		return max;
	}

}
