import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MainMethod {

	public static void main(String[] args) {
		Set<Student> list = new HashSet<>();

		Student st1 = new Student();
		st1.setId(1);
		st1.setAge(10);
		st1.setName("ABC");
		st1.setMobileNumber("1234567890");

		Student st2 = new Student(2, "XYZ", 20, "45678945678");
		Student st3 = new Student(3, "XYZ", 10, "45623945678");
		Student st4 = new Student(4, "XYZ", 20, "42678945678");
		Student st5 = new Student(5, "XYZ", 15, "45678935678");

		list.add(st1);
		list.add(st2);
		list.add(st3);
		list.add(st4);
		list.add(st5);

		System.out.println(list);

		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(!list.isEmpty());
		System.out.println("......................");
		System.out.println(list.contains(st1));

		list.remove(4);
		System.out.println(list);

		List<Integer> ages = new ArrayList<>();
//		int i = 0;
		for (Student s : list) {
			System.out.println(s);
			ages.add(s.getAge());
//			list.remove(0);
//			i++;
		}
		System.out.println(ages);

		System.out.println(";;;;;;;;;;;;;;;");
		List<Integer> agesList = list.stream().map(x -> x.getAge()).collect(Collectors.toList());
		System.out.println(agesList);

		List<Integer> list1 = getData();
		if (list1 != null && list1.isEmpty()) {
			System.out.println(list1);
		}
	}

	private static List<Integer> getData() {
		return null;
	}
}
