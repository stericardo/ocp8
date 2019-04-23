import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Chapter7Innerclass{
	
		private int valor = 10;
		public void init(){
			Chapter7Innerclass.MyInner myInner = new Chapter7Innerclass.MyInner();
			
			MyInner myInner2 = new MyInner();
			myInner.setValue();
			this.toString();
			myInner2.setValue(5454);
		}
		
		public static void main ( String[] args){
			MyInnerOut myOut = new MyInnerOut();
			myOut.setValueOut();
			Chapter7Innerclass chapter7Innerclass = new Chapter7Innerclass();
			Chapter7Innerclass.MyInner myInner = chapter7Innerclass.new MyInner();
			String value = myInner.tryAccess;
			Chapter7Innerclass.MyInner myInner2 = new Chapter7Innerclass().new MyInner();
			MyInner myInner3 = new Chapter7Innerclass().new MyInner();
			chapter7Innerclass.toString();
			chapter7Innerclass.init();
			chapter7Innerclass.toString();
			myInner.setValue(999911);
			chapter7Innerclass.toString();
			myInner2.setValue(999922); // do not change because we have a new Intance here myInner2
			chapter7Innerclass.toString();
			myInner3.setValue(999933); // do not change because we have a new Intance here myInner3
			chapter7Innerclass.toString();
			B b = new B () {
				public void hi(){
					
				}	
				public void hiC2(){
					System.out.println("ANONY ----");
		}
			};
			b.hiC();
			
			B b2 = new B ();
			b2.hi();
		}
		
		public class MyInner {
		
				private String tryAccess = "Imposible";
				
				public void setValue(){
					class Cesar {
					}
					
					valor = 10014;
					this.tryAccess = "Here is posible";
					
					System.out.println("This 1>>>!!! " + this);
					System.out.println("This 2>>>!!! " + Chapter7Innerclass.this);
					
				}
				
				static final int valueTttt=0; 	
				
				
				public void setValue(int v){
					//this.valor = v; Does not compile
					valor = v;
					System.out.println("This SET VALUE >>> " + Chapter7Innerclass.this);
					Chapter7Innerclass.this.valor=2323232;
				}
				
				public String toString(){
					String result = "Valor MyInner To String === " + tryAccess + " valor= " + valor;
					System.out.println(result);
					return result;
				}
			
		}
		
		static class MyStatic {
				int valor = 10;
				public void setValue(){
					System.out.println("Value TT ");
					valor = 10014;
					MyStatic2.setValueT();
				}	
				
				static void setValueT(){
					System.out.println("SET Value TT ");
				}		
		}
		
	static class MyStatic2 {
				int valor = 10;
				public void setValue(){
					System.out.println("Value TT 22");
					valor = 10014;
					MyStatic.setValueT();
				}	
				
				static void setValueT(){
					System.out.println("SET Value TT22 ");
				}		
		}
	
	public String toString(){
			String result = "Valor To String === " + valor;
			System.out.println(result);
			return result;
	}

	
}

class B extends C{
	
	Chapter7Innerclass chapter7Innerclass = new Chapter7Innerclass();
	Chapter7Innerclass.MyInner myInner = chapter7Innerclass.new MyInner();
	  Chapter7Innerclass.MyStatic obj=new Chapter7Innerclass.MyStatic();  
		
		
	public void hi(){
		obj.setValueT();  
		// not allowed Chapter7Innerclass.MyStatic.setValue();  
		obj.setValue();
		}
		
		
	}


class C {
	
	public void hiC(){
		System.out.println("C ----");
		}
	}
	
	class MyInnerOut {
		int valor = 444;
		public void setValueOut(){
					
					System.out.println("Value OUT OUT >>> " + this);
					valor = 55656566;
				}
	}
	
class OuterAccess{
	
	Chapter7Innerclass chapter7Innerclass = new Chapter7Innerclass();
	Chapter7Innerclass.MyInner myInner = chapter7Innerclass.new MyInner();
	Chapter7Innerclass.MyInner myInner2 = new Chapter7Innerclass().new MyInner();
	
	public void tryAccess(){
		//String value = myInner.tryAccess; private Access
	}
}
