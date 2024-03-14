package TPS;

public class characterPresent {
public static void main(String[] args) {
	String s="Salman";
	
	for(int i=0;i<s.length();i++) {
		if(s.charAt(i)=='l'||s.charAt(i)=='L') {
			System.out.println(i);
		}
	}
}
}
