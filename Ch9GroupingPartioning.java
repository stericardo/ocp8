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

public class Ch9GroupingPartioning {
	
	public static void main(String[] args){
		Ch9GroupingPartioning ch9GroupingPartioning = new Ch9GroupingPartioning();
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog("Steven", 10, 40));
		dogs.add(new Dog("Steven2", 9, 70));
		dogs.add(new Dog("Steven3", 8, 130));
		dogs.add(new Dog("Steven4", 7, 20));
		dogs.add(new Dog("Steven5", 17, 130));
		ch9GroupingPartioning.printStream(dogs.stream().sorted((d1,d2) -> d1.getWeight() - d2.getWeight()));
		//sorted does not work on the next line because of collector is a Map
		Map<Integer, List<Dog>> dogByWeight = dogs.stream().sorted((d1,d2) -> d1.getWeight() - d2.getWeight()).collect(Collectors.groupingBy(Dog::getWeight));
		System.out.println("\n" + dogByWeight);
		
		Map<Integer, Long> dogByWeight2 = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.counting()));
		System.out.println("\n" + dogByWeight2);
		
		Map<Integer, List<String>> dogByWeight3 = dogs.stream().collect(Collectors.groupingBy(Dog::getWeight, Collectors.mapping(Dog::getName, Collectors.toList())));
		System.out.println("\n" + dogByWeight3);
		
		Map<Boolean, List<Dog>> dogByWeight4 = dogs.stream().collect(Collectors.partitioningBy(d -> d.getWeight() > 50));
		System.out.println("\n\n\n Partitioning::: " + dogByWeight4);
		
		Map<Boolean, Long> dogByWeight5 = dogs.stream().collect(Collectors.partitioningBy(d -> d.getWeight() > 50, Collectors.counting()));
		System.out.println("\n\n\n Partitioning::: " + dogByWeight5);
		
		Map<Boolean, List<String>> dogByWeight6 = dogs.stream().collect(Collectors.partitioningBy(d -> d.getWeight() > 50, Collectors.mapping(Dog::getName, Collectors.toList())));
		System.out.println("\n\n\n Partitioning::: " + dogByWeight6);
		
		
	}
	
	private <T> void printStream(Stream<T> stream){
		stream.forEach(System.out::println);
	}

}

class Dog implements Comparable<Dog>{
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
	
	@Override
	public int compareTo(Dog dog){
			return this.weight > dog.getWeight()? 1: this.weight == dog.getWeight()? 0 : -1 ;
	}
}
		
