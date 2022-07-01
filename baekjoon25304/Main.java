package baekjoon25304;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = stoi(br.readLine());
		int N = stoi(br.readLine());

		int newSum = 0;

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			int a = stoi(s[0]);
			int b = stoi(s[1]);
			newSum += a * b;
		}

		if (sum == newSum) {
			System.out.println("Yes");
		} else
			System.out.println("No");
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
