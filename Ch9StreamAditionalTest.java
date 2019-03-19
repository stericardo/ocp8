import java.util.stream.Stream;
import java.util.stream.*;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.BiFunction;
import java.util.Locale;
import java.util.function.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.concurrent.ConcurrentHashMap;
import java.io.*;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Ch9StreamAditionalTest {
	


    public static void main(String[] args) throws Exception {
		new TestClass();
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog("Steven", 10, 40));
		dogs.add(new Dog("Steven2", 9, 70));
		dogs.add(new Dog("Steven3", 8, 130));
		dogs.add(new Dog("Steven3", 8, 130));
		dogs.add(new Dog("Steven4", 7, 20));
		dogs.add(new Dog("Steven5", 17, 130));
		
		
			Map<Boolean, List<String>> dogByWeight6 = dogs.stream().collect(Collectors.partitioningBy(d -> d.getWeight() > 50, Collectors.mapping(Dog::getName, Collectors.toList())));
		//System.out.println("\n\n\n Partitioning::: " + dogByWeight6);
		 // Create a list of strings 
        ArrayList<String> al = new ArrayList<String>(); 
        al.add("Geeks For Geeks"); 
        al.add("Friends"); 
        al.add("Dear"); 
        al.add("Is"); 
        al.add("Superb"); 
  
        // Creating a list of Strings 
        List<String> list = Arrays.asList("1", "2", "3", 
                                          "4", "5"); 
  
        // Using Stream flatMapToInt(Function mapper) 
        //list.stream().flatMapToInt(num -> IntStream.of(Integer.parseInt(num))). 
        //forEach(System.out::println); 
        
        //list.stream().mapToInt(num -> Integer.parseInt(num)). 
        //forEach(System.out::println); 
        
       double[] array = {10,30,50,20,70};
    	  //Set start value. Result will be start value + sum of array. 
    	  int startValue = 1;
    	  OptionalDouble sum = Arrays.stream(array).reduce( (x,y) -> x+y);
    	  System.out.println(sum);
        
			
	}
		
}	

 class TestClass {
    public static void m1() throws Exception{
        throw new Exception("Exception from m1");
    }
    public static void m2() throws Exception{
        try{
            m1();
        }catch(Exception e){
            //Can't do much about this exception so rethrow it
            throw e;
        }finally{
            throw new RuntimeException("Exception from finally");
        }
	}
}
        
    

