import java.util.Optional;

public class Example {

	public static void main(String[] args) {
		String s = null;
		if (s != null && s.isEmpty()) {
			s = s.toLowerCase();
			System.out.println(s);
		}

		Optional<String> s1 = Optional.ofNullable(s); //.orElseThrow(()-> throw new RuntimeException());
		System.out.println(s1);
		s1.ifPresent(x-> System.out.println(x.toUpperCase()));
		if (s1.isPresent()) {
			String s2 = s1.get().toLowerCase();
			System.out.println(s2);
		}
		
		//Optional.of("Hi");
	}
}
