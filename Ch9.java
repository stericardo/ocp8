import java.util.stream.Stream;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.BiFunction;
import java.util.Locale;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Ch9 {
	
	public static void main(String[] args) throws IOException{
		Double[] arrayDouble = {100.10,34.45,56.78};
		List<Double> listDouble = Arrays.asList(arrayDouble);
		Stream<Double> result = listDouble.stream().filter( d-> d > 50.00);
		Ch9 ch9 = new Ch9();
		ch9.printStream(result);
		result = listDouble.stream().filter( d-> d > 50.00);
		System.out.println(result.count());
		Map<String, String> map = new HashMap<>();
		map.put("1", "Hi");
		map.put("2", "Hi - 2");
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		Stream<Map.Entry<String, String>> mapStream = entrySet.stream();
		ch9.printStream(mapStream);
		
		Integer[] valuesInteger = {10,20,30};
		Stream<Integer> integerStream = Stream.of(valuesInteger);
		ch9.printStream(integerStream);
		
		Stream<String> linesFile = Files.lines(Paths.get("file.txt"));
		linesFile.forEach(System.out::println);
		
	}
	
	private <T> void printStream(Stream<T> stream){
		stream.forEach(System.out::println);
	}

}
		
