import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example2 {

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

		List<Student> newList = list.stream().sorted((x1, x2) -> x1.getId() - x2.getId()).collect(Collectors.toList());
		System.out.println(newList);
		List<Student> newList1 = list.stream().sorted((x1, x2) -> x2.getId() - x1.getId()).collect(Collectors.toList());
		System.out.println(newList1);
		
		List<Student> newList2 = list.stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());
		System.out.println(newList2);
		
		List<Student> newList3 = list.stream().sorted(Comparator.comparing(Student::getId).reversed()).collect(Collectors.toList());
		System.out.println(newList3);

		List<Student> newList4 = list.stream().sorted(Comparator.comparing(Student::getId).thenComparing(Student::getName)).collect(Collectors.toList());
		System.out.println(newList4);
	}
}
