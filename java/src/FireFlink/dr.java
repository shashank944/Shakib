package FireFlink;
import java.util.*;
import java.util.ArrayList;



public class dr {
	public static void main(String[] args) {
		List<sam> s=new ArrayList<>();
		s.add(new sam("agf",78,76.66));
		s.add(new sam("adt",31,70.66));
		s.add(new sam("asdtgf",23,76.66));
		double sum=0;
		int d=0;
	for(sam s1:s) {
		if(s1.age>30) {
			sum=+s1.sal;
			d++;
		}
		
	}
	System.out.println(sum/d);
	}

}
