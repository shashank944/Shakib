package Important_Java_Prgrms;

import java.util.Scanner;

public class Two_D_array {
public static void main(String[] args) {
	
	int[][] e= {{6,7,8},{34,9}};
	
	
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the size of an row in array");
	int rowsize=sc.nextInt();
	System.out.println("enter the size of an col in array");
	int colsize=sc.nextInt();
	int [][] a =new int[rowsize][colsize];
	System.out.println("Enter the array list");
	for(int i=0;i<a.length;i++) {
		
		for(int j=0;j<a.length;j++) {
			a[i][j]=sc.nextInt();
		}
	}
	System.out.println("List of arrays");
for(int i=0;i<a.length;i++) {
		
		for(int j=0;j<a.length;j++) {
			System.out.print(a[i][j]+" ");
			
		}
		System.out.println();
	}

int max=0;
System.out.println("========");
for(int i=0;i<a.length;i++) {
	
	for(int j=0;j<a.length;j++) {
		
		if(max<a[i][j]) {
			max=a[i][j];
			
		}
		System.out.println(max );
	
	
		
	}
}
}}
