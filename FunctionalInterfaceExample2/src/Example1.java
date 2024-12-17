import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Example1 {

	public static void main(String[] args) {

		Student st1 = new Student();
		st1.setId(1);
		st1.setAge(10);
		st1.setName("ABC");
		st1.setMobileNumber("1234567890");

		Student st2 = new Student(2, "XYZ", 20, "45678945678");
		Student st3 = new Student(3, "XYZ", 10, "45623945678");
		Student st4 = new Student(4, "CYX", 20, "42678945678");
		Student st5 = new Student(5, "XYZ", 15, "45678935678");

		List<Student> list = new ArrayList<>();
		list.add(st1);
		list.add(st2);
		list.add(st3);
		list.add(st4);
		list.add(st5);

		Predicate<Student> p = (x) -> {
			return x.getName().equals("XYZ");
		};

		for (Student s : list) {
			boolean result = p.test(s);
			System.out.println(result);
		}
	}
}
