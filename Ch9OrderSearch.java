import java.util.stream.Stream;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Optional;
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
import java.util.stream.Collectors;

public class Ch9OrderSearch {
	
	public static void main(String[] args){
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog("Steven", 10, 10));
		dogs.add(new Dog("Steven2", 9, 20));
		dogs.add(new Dog("Steven3", 8, 30));
		dogs.add(new Dog("Steven4", 7, 40));
		boolean cNames = dogs.stream().filter(w-> w.getWeight()> 20).anyMatch(d -> d.getName().startsWith("S"));
		System.out.println("Dogs > 50 and Starts with S: " + cNames);
		
		long count = dogs.stream().filter(w-> w.getWeight()> 20).count();
		System.out.println("Dogs > 50 and Starts with S Count : " + count);
		
		cNames = dogs.stream().filter(w-> w.getWeight()> 20).allMatch(d -> d.getName().startsWith("S"));
		System.out.println("All Match >>> Dogs > 50 and Starts with S  : " + cNames);
		
		cNames = dogs.stream().filter(w-> w.getWeight()> 20).noneMatch(d -> d.getName().startsWith("S"));
		System.out.println("None Match >>> Dogs > 50 and Starts with S : " + cNames);
		
		cNames = dogs.stream().filter(w-> w.getWeight()> 20).noneMatch(d -> d.getName().startsWith("SAP"));
		System.out.println("None Match >>> Dogs > 50 and Starts with SAP : " + cNames);
		
		Optional<Dog> dogOptional = dogs.stream().filter(w-> w.getWeight()> 20).findAny();
		if(dogOptional.isPresent()){
			System.out.println("dogOptional find Any : " + dogOptional);
			System.out.println("dogOptional find Any : " + dogOptional.get());
		} else {
			System.out.println("dogOptional No present");
		}
		
		dogOptional = dogs.stream().filter(w-> w.getWeight()> 120).findAny();
		if(dogOptional.isPresent()){
			System.out.println("dogOptional find Any : " + dogOptional);
			System.out.println("dogOptional find Any : " + dogOptional.get());
		} else {
			System.out.println("dogOptional No present");
		}
		
		try(Stream<String> linesFile = Files.lines(Paths.get("file.txt"))){
			linesFile.forEach(System.out::println);
		} catch (IOException e){
		
		}
		
		try(Stream<String> streamFile = Files.lines(Paths.get("file.txt"))){
			List<String> listStringFromFile = streamFile.collect(Collectors.toList());
			listStringFromFile.forEach(System.out::println);
		} catch (IOException e){
		
		}
		
		
		
	}
	
	private <T> void printStream(Stream<T> stream){
		stream.forEach(System.out::println);
	}

}

class Dog {
	private String name;
	private int age;
	private int weight;
	
	public Dog(String name, int age, int weight){
			this.name= name;
			this.age= age;
			this.weight= weight;
	}
	
	public String toString(){
		return "Name= " + this.name + " Age= " + this.age + " weight= " + this.weight;
	}
	
	public int getWeight(){
		return this.weight;
	}
	
	public String getName(){
		return this.name;
	}
}
		
