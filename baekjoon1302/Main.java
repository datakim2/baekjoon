package baekjoon1302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		TreeMap<String, Integer> dictionary = new TreeMap<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			dictionary.put(word, dictionary.getOrDefault(word, 0) + 1);
		}

		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(dictionary.entrySet());

		entryList.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

		System.out.println(entryList.get(0).getKey());
	}

}
