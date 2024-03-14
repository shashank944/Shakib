package FireFlink;

public class getter {

	private String a;
	private int b;
	
	public String geta() {
		return a;
		
	}
	public  void seta(String a) {
		this.a=a;
		
	}
	public int getb() {
		return b;
		
	}
	public void setb(int b) {
		this.b=b;
		
	}
}

class driver{
	public static void main(String[] args) {
		getter g=new getter();
		g.seta("vhsc");
		g.setb(10);
		System.out.println(g.geta());System.out.println(g.getb());
	}
}