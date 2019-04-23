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
		List<Integer> listInteger = Arrays.asList(1,2,3,4);
		 double valueDouble = listInteger.stream().reduce((x,y)-> x + y).average();
		
			
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
        
    

