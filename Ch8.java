//https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx

import java.util.List;
import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Consumer;

public class Ch8 {
	
		public static void main(String[] args){
			BiPredicate<String, String> evaluateMayorBiPredicate = (a, b) -> 0 == a.compareTo(b) ||  a.compareTo(b) > 0 ;
			List<String> names = new ArrayList<>();
			names.add("Steven");
			names.add("Ricardo");
			names.add("Mendez");
			names.add("Brenes");
			Ch8 ch8 = new Ch8();
			names = ch8.filter(names, evaluateMayorBiPredicate);
			names.forEach(System.out::println);
			
			names = ch8.filter(names, (a, b) -> 0 == a.compareTo(b) ||  a.compareTo(b) > 0 );
			names.forEach(System.out::println);
			
			// Create a reference Method and use it.
			BiPredicate<String, String> evaluateMayorBiPredicateSecondVersion = (a, b) -> StringValidation.evaluateMayor(a,b);
			names = ch8.filter(names, evaluateMayorBiPredicateSecondVersion);
			names.forEach(System.out::println);
			System.out.println("Webooonnnnnnn");
			
			// 	First Method 
			//  Static method reference
			//  (args) -> Class.staticMethod(args)
			names = ch8.filter(names, StringValidation::evaluateMayor);
			names.forEach(System.out::println);
			
			//Second Method
			//  Instance method reference of an object of a particular type
			//  (obj, args) -> obj.instanceMethod(args)
			List<Shipment> l = new ArrayList<Shipment>();
			l.add(new Shipment());
			l.add(new Shipment());
			l.add(new Shipment());
			Function<Shipment, Double> functionShipment = f -> f.calculateWeight();
			List<Double> resultsCalculateOnShipments =ch8.calculateOnShipments(l, functionShipment);
			resultsCalculateOnShipments.forEach(System.out::println);
			System.out.println("Method Reference");
			resultsCalculateOnShipments =ch8.calculateOnShipments(l, Shipment::calculateWeight);
			resultsCalculateOnShipments.forEach(System.out::println);
			
			//Tri FUnction example:
			TriFunction<Sum, String, String, Integer> anon =
			  new TriFunction<Sum, String, String, Integer>() {
				@Override
				public Integer apply(Sum s, String arg1, String arg2) {
				  return s.doSum(arg1, arg2);
				}
			};
			System.out.println(anon.apply(new Sum(), "2", "5"));
			
			anon = (a,b,c) -> a.doSum(b,c);
			System.out.println(anon.apply(new Sum(), "3", "2"));
			
			anon = Sum::doSum;
			System.out.println(anon.apply(new Sum(), "7", "8"));
			
			//Third Method
			//Instance method reference of an existing object
			//(args) -> obj.instanceMethod(args)
			final Mechanic mechanic = new Mechanic();
			Car car = new Car();

			// Using an anonymous class
			ch8.execute(car, new Consumer<Car>() {
			  public void accept(Car c) {
				mechanic.fix(c);
			  }
			});
			
			Consumer<Car> consumer = c -> mechanic.fix(c);
			ch8.execute(car, consumer);
			
			ch8.execute(car, mechanic::fix);
			
			Consumer<String> c = System.out::println;
			c.accept("Print Hello");

			
			
			
		}
		
		// First Method
		private List<String> filter(List<String> list, BiPredicate<String, String> biPredicate){
			List<String> namesResult = new ArrayList<>();
			for(String name : list){
					if(biPredicate.test(name, "Meza")){
						namesResult.add(name);
					}
			}
			return namesResult;
		}
		
		//Second Method
		
		public List<Double> calculateOnShipments(
		  List<Shipment> l, Function<Shipment, Double> f) {
			List<Double> results = new ArrayList<>();
			for(Shipment s : l) {
			  results.add(f.apply(s));
			}
			return results;
		}
		
		//Third Method 
		public void execute(Car car, Consumer<Car> c) {
		  c.accept(car);
		}
			
}

//First Method

class StringValidation {
	
	public static boolean evaluateMayor(String a, String b){
		System.out.println("- Enter - ");
		return 0 == a.compareTo(b) ||  a.compareTo(b) > 0;
	}
}

//Second Mehod

class Shipment {
  public double calculateWeight() {
    double weight = 0;
    return weight + 122.4;
  }
}


// Tri function implementation
interface TriFunction<T, U, V, R> {
  R apply(T t, U u, V v);
}

class Sum {
  Integer doSum(String s1, String s2) {
	  System.out.println(s1 + ":::::" +s2);
    return Integer.parseInt(s1) + Integer.parseInt(s2);
  }
}

// Third Method

class Car {
  private int id;
  private String color;
  
  public int getId(){
	return id;
  }
  // More properties
  // And getter and setters
}
class Mechanic {
  public void fix(Car c) {
    System.out.println("Fixing car " + c.getId());
  }
}
