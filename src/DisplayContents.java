import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class DisplayContents implements IFunction {

	@Override
	public void call(Object arg, IFunction function) {
		// TODO Auto-generated method stub
		Map<Object,Integer> frequencyMap=(Map<Object,Integer>)arg;
		Set<Entry<Object, Integer>> treeMapSet = frequencyMap.entrySet();
		Iterator<Entry<Object, Integer>> it = treeMapSet.iterator();
		int entryCount = 0;
		while (it.hasNext() && entryCount < 25) {
			entryCount++;
			Map.Entry mapEntry = (Map.Entry) it.next();
			System.out.println((String)mapEntry.getKey() + " - " + mapEntry.getValue());
		}

	}

}
