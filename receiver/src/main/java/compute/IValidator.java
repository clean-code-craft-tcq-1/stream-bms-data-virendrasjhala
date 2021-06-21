package compute;

import java.util.List;

public interface IValidator {
	
	public default boolean isNotNullOrEmpty(List<Double> paramValueList){
		return paramValueList != null && !paramValueList.isEmpty();
	}

}
