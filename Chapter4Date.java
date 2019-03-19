import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Chapter4Date{
	

		public static void main ( String[] args){
			System.out.println("Date chapter 4");
			LocalDate localDate = LocalDate.of(2017, 12, 13);
			System.out.println(localDate);
			
			Period period = Period.ofMonths(1);
			System.out.println("Period " + period);
			
			long value = 1034L ;
			float floatValue = 10.34f;
			boolean valueBol = false;
			String output = String.format( "%d%f%s", value, floatValue, valueBol );
			System.out.println(output);
			List<? super B> list = new ArrayList<Integer>();
			addValueHelper(list);
			System.out.println(output);
		}
	
	public static void addValueHelper(List list){
			Object b = new B();
			list.add(b);
	}
	
	
}

class B extends Chapter4Date
{
	public B(){
		}
}
