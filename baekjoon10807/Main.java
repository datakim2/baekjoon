package baekjoon10807;

import java.io.*;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		int N = stoi(br.readLine());
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			map.put(s[i], map.getOrDefault(s[i], 0) + 1);
		}

		String key = br.readLine();
		if (map.get(key) == null) {
			System.out.println(0);
		} else {
			System.out.println(map.get(key));

		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
