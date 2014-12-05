public class HelloWorld
{
	public static void main(String[] args) {
		HelloWorld h = new HelloWorld();
		h.perform();
		System.out.println("Hello World!!");
	}

	public void perform() {
		int i = 30;
		int j = 40;
		int k = 50;
		int l;
		l = (i + j) * k;
		
		System.out.println(l);
	}
}
