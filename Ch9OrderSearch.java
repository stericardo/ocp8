import java.util.stream.Stream;
import java.util.List;
import java.util.Set;
import java.util.Comparator;
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
import java.util.function.DoubleSupplier;
import java.nio.file.Path;

public class Ch9OrderSearch {
	
	static String[] sa = { "a", "aa", "aaa", "aaaa" };
    static
    {
        Arrays.sort(sa);
    }
    
	public static void main(String[] args){
		
		List<Integer> ls = Arrays.asList(1,2,6,9,6,5,7);
System.out.println("1)" + ls.stream().reduce(Integer.MIN_VALUE, (a, b)->a>b?a:b)); //1
System.out.println("2)" + ls.stream().max(Integer::max).get()); //2
System.out.println("3)" + ls.stream().max(Integer::compare).get()); //3
System.out.println("4)" + ls.stream().max((a, b)->a>b?a:b)); //4
		
		Path p1 = Paths.get("x\\y");
        Path p2 = Paths.get("z");
        Path p3 = p1.relativize(p2);
        System.out.println(p3);
        
        System.out.println(p2.relativize(p1));
        
        Path path01 = Paths.get("Topic.txt");
        Path path02 = Paths.get("Demo.txt");
        Path path03 = Paths.get("/Java/JavaFX/Topic.txt");
        Path path04 = Paths.get("/Java/2011");

        Path path01_to_path02 = path01.relativize(path02);
        System.out.println(path01_to_path02);

        Path path02_to_path01 = path02.relativize(path01);
        System.out.println(path02_to_path01);

        Path path03_to_path04 = path03.relativize(path04);
        System.out.println(path03_to_path04);

        Path path04_to_path03 = path04.relativize(path03);
        System.out.println(path04_to_path03);
        
        
        
		
		 String search = "";
        if(args.length != 0) search = args[0];
        System.out.println(Arrays.binarySearch(sa, search));
		
		Ch9OrderSearch ch9OrderSearch = new Ch9OrderSearch();
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog("Steven", 10, 10));
		dogs.add(new Dog("Andres", 9, 20));
		dogs.add(new Dog("Andres", 9, 18));
		dogs.add(new Dog("Andres", 9, 21));
		dogs.add(new Dog("Marta", 8, 30));
		dogs.add(new Dog("Marta", 8, 31));
		dogs.add(new Dog("Marta", 8, 29));
		dogs.add(new Dog("Sebastian", 7, 40));
		
		
		Comparator<Dog> c1 =  (b1, b2)->b1.getName().compareTo(b2.getName()); //1
		ch9OrderSearch.printStream(dogs.stream().sorted(c1.thenComparing(Dog::getWeight))); //2
		System.out.println("End Dogs >>> " + dogs);
		
		
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
		String[] arrayString = {"1", "2"};
		List<?> listString = new ArrayList<>(Arrays.asList("1", "2"));
		ch9OrderSearch.modify(listString);
		ch9OrderSearch.printStream(listString.stream());
		Dog dogTemp = new Dog("StevenTemmp", 10, 10);
		DoubleSupplier dSup = () -> dogTemp.dou ;
		System.out.println(dSup.getAsDouble());
	
	}
	
	private void modify(List listString){
		//listString.add(new String());
		//listString.add(new String("St"));
	}
	
	private <T> void printStream(Stream<T> stream){
		stream.forEach(System.out::println);
	}

}

class Dog {
	private String name;
	private int age;
	private int weight;
	public Double dou= null;
	
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


