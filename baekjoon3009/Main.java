package baekjoon3009;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean[] isPairX = new boolean[1001];
	static boolean[] isPairY = new boolean[1001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 3; i++) {
			String[] s = br.readLine().split(" ");
			if (isPairX[stoi(s[0])]) {
				isPairX[stoi(s[0])] = false;
			} else {
				isPairX[stoi(s[0])] = true;
			}
			if (isPairY[stoi(s[1])]) {
				isPairY[stoi(s[1])] = false;
			} else {
				isPairY[stoi(s[1])] = true;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 1000; i++) {
			if (isPairX[i]) {
				sb.append(i + " ");
			}
		}
		for (int i = 1; i <= 1000; i++) {
			if (isPairY[i]) {
				sb.append(i);
			}
		}

		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
