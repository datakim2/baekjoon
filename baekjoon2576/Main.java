package baekjoon2576;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 7; i++) {
			int a = stoi(br.readLine());
			if (a % 2 == 1) {
				min = Math.min(min, a);
				sum += a;
			}
		}

		if (sum == 0) {
			System.out.println(-1);
		} else {

			System.out.println(sum);
			System.out.println(min);
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
