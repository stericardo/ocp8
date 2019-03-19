import java.io.IOException;

public class Test {
	
		public enum Days {MON, TUE, WED}
		public static void main(String[] args){
			for(Days d: Days.values()){
				System.out.println(d);
				}
			;
			Days[] days = Days.values();
			System.out.println(days[2]);
			Test test1 = new Test();
			Test test2 = new Test();
			System.out.println(test1.equals(test2));
			
		}
	
	
}

class A {
	
	protected void getA() throws Exception{
		}
		
		protected void getAZ2() throws Exception{
		}
	}
	
	class B extends A {
	

	public String getA(int y) throws Exception{
		int x = 10;
		super.getAZ2();
		return null;
		}
		
		public void getA(long y) throws IOException{
		int x = 10;
		}
	}
