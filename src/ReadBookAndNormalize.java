import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadBookAndNormalize implements IFunction {

	public void call(Object arg, IFunction func) {
		String fileName = (String) arg;
		List<String> bookWords=null;
		try {
			bookWords = Files.lines(Paths.get(fileName))
					.flatMap(line -> Arrays.stream(line.split("[\\s,;:?._!--]+"))).map(s -> s.toLowerCase())
					.collect(Collectors.toList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		func.call(bookWords, new SortMap());
	}

}
