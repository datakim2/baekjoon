package baekjoon1107;

import java.io.*;
import java.util.ArrayList;

public class Main {
	static int N, M, ans = Integer.MAX_VALUE;
	static boolean[] isVisited = new boolean[500001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = stoi(br.readLine());

		M = stoi(br.readLine());
		
		String[] s = null;
		
		if(M>0) {
		s = br.readLine().split(" ");
		}
		for (int i = 0; i < M; i++) {
			isVisited[stoi(s[i])] = true;
		}

		if (N == 100) {
			System.out.println(0);
			System.exit(0);
		}

		solve();

	}

	static void solve() {

		int num = Math.abs(N - 100);

		for (int i = 0; i < 1000000; i++) {

			String s = Integer.toString(i);
			int len = s.length();

			boolean isPossible = false;

			for (int j = 0; j < len; j++) {
				if (isVisited[s.charAt(j) - '0']) {
					isPossible = true;
					break;
				}
			}
			if (!isPossible) {
				int val = Math.abs(N - i) + len;
				num = Math.min(val, num);
			}
		}
		System.out.println(num);

	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
