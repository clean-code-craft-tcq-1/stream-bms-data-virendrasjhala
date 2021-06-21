package compute;

import java.util.List;
import java.util.function.Function;

public class MinimumComputerFunction implements IValidator,Function<List<Double>, Double> {

	@Override
	public Double apply(List<Double> paramValueList) {
		Double min = null;
		if (isNotNullOrEmpty(paramValueList)) {
			min = paramValueList.stream().mapToDouble(value -> value.doubleValue()).min().getAsDouble();
		}
		return min;
	}

}
