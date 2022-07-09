package baekjoon2460;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int in = 0;
		int out = 0;
		int sum = 0;
		int max = -1;
		for (int i = 0; i < 10; i++) {
			String[] s = br.readLine().split(" ");
			out = stoi(s[0]);
			in = stoi(s[1]);
			sum -= out;
			sum += in;
			max = Math.max(max, sum);

		}

		System.out.println(max);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
