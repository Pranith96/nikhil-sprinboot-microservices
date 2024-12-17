import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample2 {

	public static void main(String[] args) {
		Set<String> list = new TreeSet<>();
		
		list.add("Abc");
		list.add("PQR");
		list.add("Abc");
		list.add("XYZ");
		
		System.out.println(list);
	}
}