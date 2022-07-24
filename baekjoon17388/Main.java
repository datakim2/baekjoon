package baekjoon17388;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int[] uni = new int[3];

		for (int i = 0; i < 3; i++) {
			uni[i] = stoi(s[i]);
		}

		int sum = uni[0] + uni[1] + uni[2];
		int min = 101;

		if (sum >= 100) {
			System.out.println("OK");
			System.exit(0);
		} else {
			min = Math.min(Math.min(uni[0], uni[1]), uni[2]);
		}

		for (int i = 0; i < 3; i++) {
			if (min == uni[0]) {
				System.out.println("Soongsil");
				System.exit(0);
			} else if (min == uni[1]) {
				System.out.println("Korea");
				System.exit(0);
			} else if (min == uni[2]) {
				System.out.println("Hanyang");
				System.exit(0);

			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
