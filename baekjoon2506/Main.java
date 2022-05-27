package baekjoon2506;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = stoi(br.readLine());

		String[] s = br.readLine().split(" ");

		boolean isOne = false;

		int sum = 0;

		int one = 1;

		for (int i = 0; i < N; i++) {

			int cur = stoi(s[i]);

			if (cur == 1) {

				if (isOne) {
					sum += ++one;
				} else {
					sum += one;
					isOne = true;
				}
			} else {
				isOne = false;
				one = 1;
			}
		}
		System.out.println(sum);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
