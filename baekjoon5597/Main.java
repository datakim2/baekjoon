package baekjoon5597;

import java.io.*;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 28; i++) {
			set.add(stoi(br.readLine()));
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 30; i++) {
			if (!set.contains(i)) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
