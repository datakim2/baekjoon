package hi;

import java.io.*;

public class Main {
	static int[] ball;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int N = stoi(s[0]);
		int M = stoi(s[1]);

		ball = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			ball[i] = i;
		}

		for (int i = 0; i < M; i++) {

			String[] s2 = br.readLine().split(" ");
			int a = stoi(s2[0]);
			int b = stoi(s2[1]);

			swap(a, b);
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(ball[i] + " ");
		}
	}

	static void swap(int a, int b) {
		int temp = ball[a];
		ball[a] = ball[b];
		ball[b] = temp;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
