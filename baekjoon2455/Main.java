package baekjoon2455;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max = -1;

		int sum = 0;

		for (int i = 0; i < 4; i++) {
			String[] s = br.readLine().split(" ");

			int out = stoi(s[0]);
			int in = stoi(s[1]);

			sum -= out;
			max = Math.max(sum, max);
			sum += in;
			max = Math.max(sum, max);
		}

		System.out.println(max);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
