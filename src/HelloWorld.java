public class HelloWorld
{
  public static void main(String[] args)
  {
    HelloWorld h = new HelloWorld();
    h.perform();
    System.out.println("Hello World!!");
  }

  public void perform() {
    int i = 100;
    int j = 100;
    int k = (i * j - i * (j - i / j)) * (i + j) / i;

    System.out.println(k);
  }
}
