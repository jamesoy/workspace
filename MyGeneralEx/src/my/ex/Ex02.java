package my.ex;

import java.util.Map;
import java.util.TreeMap;

public class Ex02 {

	private static int a1[] = {1, 2, -3, 4, 5, -4, 1, 8, -6, 9};
	
	public static void main(String[] args) {
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		for (int i = 0; i < a1.length; i++) {
			for (int j = a1.length - 1; j >= i; j--) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += a1[k];
				}
				String p1 = i + 1 < 10 ? "0" + (i + 1) : "" + (i + 1);
				String p2 = j + 1 < 10 ? "0" + (j + 1) : "" + (j + 1);
				tm.put(p1 + "->" + p2, sum);
			}
		}
		for(Map.Entry<String, Integer> entry : tm.entrySet()) {
			  Integer value = entry.getValue();
			  String key = entry.getKey();

			  System.out.println(key + " : " + value);
		}
		System.out.println("Size: " + tm.size());
	}

}
