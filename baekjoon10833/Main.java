package baekjoon10833;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = stoi(br.readLine());

		int sum = 0;

		for (int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			int A = stoi(s[0]);
			int B = stoi(s[1]);

			sum += B % A;
		}

		System.out.println(sum);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
