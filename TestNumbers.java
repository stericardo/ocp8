import java.util.concurrent.TimeUnit;


public class TestNumbers {
	
	
			
	public static void main(String[] args){
		TestNumbers testNumbers = new TestNumbers();
		Integer i1 = 1000;
		Integer i2 = 1000;
		testNumbers.methodValidation(i1,i2);
		Integer i3 = 10;
		Integer i4 = 10;
		testNumbers.methodValidation(i3,i4);
		i3 = 127;
		i4 = 127;
		testNumbers.methodValidation(i3,i4);
		i3 = 128;
		i4 = 128;
		testNumbers.methodValidation(i3,i4);
		
		
	}
	
	private void methodValidation(Integer i1, Integer i2){
		if(i1 != i2){
			System.out.println("!=");
		}
		if(i1 == i2){
			System.out.println("==");
		}
		if(i1.equals(i2)){
			System.out.println("Equals");
		}
	}

	
	
}
