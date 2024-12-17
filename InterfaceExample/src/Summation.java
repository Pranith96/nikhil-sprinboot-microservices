
public interface Summation {
	public int sum(int b);
	public void add(int b);
	public int sub(int b);

	default void greeting() {
		System.out.println("greeting");
	}
	
	default void hi() {
		String s = "Hello";
		s = s.toUpperCase();
		System.out.println(s);
	}
	
	static void hello() {
		String s = "Hello world";
		s = s.toUpperCase();
		System.out.println(s);
	}
	
	private void welcome() {
		String s = "Hello world spring";
		s = s.toUpperCase();
		System.out.println(s);
	}
}
