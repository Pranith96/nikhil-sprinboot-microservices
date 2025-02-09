import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example3 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		Student st1 = new Student();
		st1.setId(1);
		st1.setAge(10);
		st1.setName("ABC");
		st1.setMobileNumber("1234567890");

		Student st2 = new Student(4, "XYZ", 20, "45678945678");
		Student st3 = new Student(5, "HJK", 10, "45323935678");
		Student st4 = new Student(2, "PQR", 18, "42678945478");
		Student st5 = new Student(3, "XYZ", 15, "45678335678");

		list.add(st1);
		list.add(st2);
		list.add(st3);
		list.add(st4);
		list.add(st5);

		//highest age
		Student newList2 = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).findFirst().get();
		System.out.println(newList2);
		
		//2nd highest age
		Student newList3 = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).skip(1).findFirst().get();
		System.out.println(newList3);
		
		List<Student> newList4 = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).limit(3).collect(Collectors.toList());
		System.out.println(newList4);
	}
}
