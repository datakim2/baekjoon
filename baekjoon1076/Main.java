package baekjoon1076;

import java.io.*;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<String, Integer> map = new HashMap<>();
		map.put("black", 0);
		map.put("brown", 1);
		map.put("red", 2);
		map.put("orange", 3);
		map.put("yellow", 4);
		map.put("green", 5);
		map.put("blue", 6);
		map.put("violet", 7);
		map.put("grey", 8);
		map.put("white", 9);

		long digit = 0;

		for (int i = 0; i < 3; i++) {
			String s = br.readLine();

			if (i == 0) {
				digit += map.get(s) * 10;
			} else if (i == 1) {
				digit += map.get(s);
			} else {
				digit *= (int) Math.pow(10, map.get(s));
			}

		}

		System.out.println(digit);

	}

}
