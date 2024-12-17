import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Example2 {

	public static void main(String[] args) {
		Consumer<String> c = (x) -> {
			x = x.toUpperCase();
			System.out.println(x);
		};
		c.accept("Hello world");

		Supplier<Integer> s = () -> {
			Random rn = new Random();
			int num = rn.nextInt(10);
			return num;
		};
		Integer result = s.get();
		System.out.println(result);
	}
}
