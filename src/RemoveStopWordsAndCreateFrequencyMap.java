import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveStopWordsAndCreateFrequencyMap implements IFunction {

	@Override
	public void call(Object arg, IFunction function) {
		// TODO Auto-generated method stub
		try {
			List<String> bookWords = (List<String>) arg;
			final List<String> stopWords = Files.lines(Paths.get("stop-words.txt"))
					.map(line -> line.split(",")).flatMap(Arrays::stream).collect(Collectors.toList());
			Map<Object, Integer> frequencyMap = bookWords.parallelStream()
					.filter(d -> stopWords.parallelStream().allMatch(f -> !d.equals(f) && !d.equals("") && !d.equals("s")))
					.collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
			function.call(frequencyMap, new DisplayContents());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
