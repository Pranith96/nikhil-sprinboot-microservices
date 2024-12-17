import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 6, 7, 8, 9, 10);
		List<Integer> list2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		Stream<Integer> newList = list1.stream().filter(x -> x%2 == 0);
		
		Optional<Integer> data = newList.findFirst();
		
		System.out.println(data.get());
		
//		Optional<Integer> data1 =newList.findAny();
//		System.out.println(data1);
		
		
		
		Integer v = list1.stream().filter(x -> x%2 == 0).findFirst().get();
		System.out.println(v);
		
		List<Integer> newList2 = list1.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
		System.out.println(newList2);
		
		Set<Integer> newList3 = list1.stream().filter(x -> x%2 == 0).collect(Collectors.toSet());
		System.out.println(newList3);
		
		List<Integer> newList4 = list1.stream().filter(x -> x%2 == 0).distinct().collect(Collectors.toList());
		System.out.println(newList4);
	}
}
