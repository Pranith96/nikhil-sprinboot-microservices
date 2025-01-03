import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example1 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		Student st1 = new Student();
		st1.setId(1);
		st1.setAge(10);
		st1.setName("ABC");
		st1.setMobileNumber("1234567890");

		Student st2 = new Student(4, "XYZ", 20, "45678945678");
		Student st3 = new Student(5, "HJK", 10, "45323935678");
		Student st4 = new Student(2, "PQR", 20, "42678945478");
		Student st5 = new Student(3, "XYZ", 15, "45678335678");

		list.add(st1);
		list.add(st2);
		list.add(st3);
		list.add(st4);
		list.add(st5);

		List<Student> newList = list.stream().filter(x -> x.getName().equals("XYZ")).collect(Collectors.toList());
		System.out.println(newList);

		List<String> newList1 = list.stream().filter(x -> x.getName().equals("XYZ")).map(y -> y.getName())
				.collect(Collectors.toList());
		System.out.println(newList1);

		List<String> newList2 = list.stream().filter(x -> x.getAge() <= 15).map(y -> {
			return y.getName().toLowerCase();
		})
				.collect(Collectors.toList());
		System.out.println(newList2);
	}
}
