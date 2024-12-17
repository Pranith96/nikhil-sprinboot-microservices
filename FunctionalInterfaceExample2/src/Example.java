import java.util.function.Predicate;

public class Example {

	public static void main(String[] args) {
		Predicate<Integer> p = (x) -> {
			if (x % 2 == 0) {
				return true;
			}
			return false;
		};
		boolean b = p.test(11);
		System.out.println(b);
		
		
		Predicate<Integer> p1 = x -> x % 2 == 0;
		boolean b1 = p1.test(11);
		System.out.println(b1);
	}
}
