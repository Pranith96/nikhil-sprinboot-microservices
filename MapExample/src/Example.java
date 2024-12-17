import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Example {

	public static void main(String[] args) {

		Bank b1 = new Bank();
		b1.setAccountId(1);
		b1.setAccountType("SAVINGS");
		b1.setBalance(1000.0);
		b1.setStatus("ACTIVE");

		Map<Bank, String> map = new HashMap<>(); // ConcurrenthashMap, LinkedHashMap, TreeMap, CopyOnWriteArrayList,CopyOnWriteArraySet
		map.put(b1, "BAC");
		map.put(new Bank(2, 2000.0, "ACTIVE", "LOAN"), "ABC");
		map.put(new Bank(3, 1000.0, "ACTIVE", "LOAN"), "XYZ");
		map.put(new Bank(4, 0.0, "INACTIVE", "SAVINGS"), "PQR");
		map.put(new Bank(5, 0.0, "INACTIVE", "SAVINGS"), "KJL");

		Set<Bank> banks = map.keySet();
		System.out.println(banks);

		Collection<String> list = map.values();
		System.out.println(list);

		System.out.println(map.get(b1));
		System.out.println(map.size());
		System.out.println(map.isEmpty());
		System.out.println(map.equals(new HashMap<>())); // need to use another map object
		System.out.println(map.containsKey(b1));
		System.out.println(map.containsValue("PQR"));
		//System.out.println(map.remove(b1));
		System.out.println(map);

		for (Map.Entry<Bank, String> m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
			map.remove(b1);
		}
	}
}
