package baekjoon22233;

import java.io.*;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] s = br.readLine().split(" ");

		int N = stoi(s[0]);
		int M = stoi(s[1]);

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			String[] s2 = br.readLine().split(",");

			for (int j = 0; j < s2.length; j++) {

				set.remove(s2[j]);
			}

			sb.append(set.size()).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
