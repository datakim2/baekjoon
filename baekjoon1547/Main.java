package baekjoon1547;

import java.io.*;

public class Main {
	static int[] ball;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = stoi(br.readLine());

		ball = new int[4];

		for (int i = 1; i <= 3; i++) {
			ball[i] = i;
		}

		for (int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			int A = stoi(s[0]);
			int B = stoi(s[1]);
			swap(A, B);
		}

		for (int i = 1; i <= 3; i++) {
			if (ball[i] == 1) {
				System.out.println(i);
				System.exit(0);
			}
		}

		System.out.println(-1);
	}

	static void swap(int A, int B) {
		int temp = ball[A];
		ball[A] = ball[B];
		ball[B] = temp;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
