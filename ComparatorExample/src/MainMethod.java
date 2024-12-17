import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MainMethod {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		Student st1 = new Student();
		st1.setId(1);
		st1.setAge(10);
		st1.setName("ABC");
		st1.setMobileNumber("1234567890");

		Student st2 = new Student(2, "XYZ", 20, "45678945678");
		Student st3 = new Student(3, "PQR", 10, "45623945678");
		Student st4 = new Student(4, "BHG", 20, "42678945678");
		Student st5 = new Student(5, "CSA", 15, "45678935678");

		list.add(st1);
		list.add(st2);
		list.add(st3);
		list.add(st4);
		list.add(st5);

		// System.out.println(list);

		Collections.sort(list, new NameComparator());

		// System.out.println(list);
		for (Student s : list) {

		}

		Iterator<Student> it = list.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		//	list.remove(0);
		}
	}
}
