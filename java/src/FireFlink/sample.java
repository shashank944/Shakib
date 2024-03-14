package FireFlink;

import java.util.*;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class sample {
	 
	
	  public static void main (String[] args) { 
		  
		String s= "Raj@55.551b2%a3(t";
	String a ="";
		int sum = 0;
		String b ="";
		String  num = "";
		
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(Character.isDigit(ch)) {
				num=num+s.charAt(i);
				sum=sum+Character.getNumericValue(ch);
			}
			else if(Character.isAlphabetic(ch)) {
				a=a+s.charAt(i);
			}
			else {
				b=b+s.charAt(i);
			}
		}System.out.println(sum);
		System.out.println(num);
		System.out.println(a);
		System.out.println(b);
		StringBuffer i=new StringBuffer("bh");

	  }
}