import java.util.concurrent.TimeUnit;

class E {
	
		

		public E(String h){
			}
	
}

public class Test2 extends E implements C, D {
	
	public Test2(String h){
		super("");
			}
			
	public static void main(String[] args){
		long valueLong = 9999433566;
		int valorInt = (int) valueLong;
		System.out.println(">>>" + TimeUnit.MINUTES.toSeconds(-1));
		
		A b1 = new B();
		b1.getAll();
		
		B b= new B();
		b.getAll();
		
		
		((B)b).method(); 
		System.out.println(new Test2("dsff").getV());
		
	}
	

	
	
}

class A {
	public static String valor = "Valor>>>A";
	public static void getAll(){
		
		System.out.println("A PARENT " + valor);
		}
	
}

class B extends A{
	public static String valor = "Valor>>>B";

	public static void getAll(){
		
		System.out.println("B CHild " + valor);
		
		}
	
	void method(){
		
		}
	}

interface C {
	
	default int getV(){
		return 1;
		}
	}
	
	interface D {
	
	default int getV2(){
		return 1;
		}
	}
