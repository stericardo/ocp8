import java.util.function.Function;
public class Lambdas{
	
	public static void main(String[] args)
	{
		FunctionPractice<Integer, Double> funtionPractice = v-> v + 1.0;
		Double result = funtionPractice.apply(10);
		System.out.println(result);
		
		PredicatePractice<Integer> predicatePractice = v -> {return v > 10;};
		System.out.println(predicatePractice.test(20));
		
		int value = 20;
		//value = 10; Lambdas.java:15: error: local variables referenced from a lambda expression must be final or effectively final
		SupplierPractice<Integer> supplierPractice = () -> value + 100;
		Integer resultInteger = supplierPractice.get();
		System.out.println(resultInteger);
		ConsumerPractice<Integer> consumerPractice = v-> {
				System.out.println(v+v);
			};
		
		
	}

}

@FunctionalInterface
interface FunctionPractice<T, R> { 
	R apply(T t);
}

@FunctionalInterface
interface PredicatePractice<T> {
	boolean test(T t);
}

@FunctionalInterface
interface SupplierPractice<T> {
	T get();
}
@FunctionalInterface
interface ConsumerPractice<T> {
    void accept(T t);
}
