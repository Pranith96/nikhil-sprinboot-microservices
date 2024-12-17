
public class MainMethod {

	public static void main(String[] args) {

		Addition ad = new AdditionImpl();
		ad.add(10, 10);

		Addition ad1 = (int a, int b) -> {
			System.out.println(a + b);
		};
		ad1.add(20, 20);

		Addition ad2 = (a, b) -> System.out.println(a + b);
		ad2.add(30, 20);

		Summation sm = x -> {
//			for (int i = 0; i < x; i++) {
//				System.out.println(i);
//			}
			return x;
		};
		int result = sm.sum(4);
		System.out.println(result);
	}
}
