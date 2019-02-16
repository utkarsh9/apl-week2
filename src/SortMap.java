import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMap implements IFunction {

	@Override
	public void call(Object arg, IFunction function) {
		// TODO Auto-generated method stub
		Map<Object, Integer> unsortedMap = (Map<Object, Integer>) arg;
		Map<Object, Integer> result=unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(
				Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		function.call(result, new ReturnFunction());

	}

}
