package baekjoon11945;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int N = stoi(s[0]);
		int M = stoi(s[1]);
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s2 = br.readLine();
			int idx = 0;
			for (int j = M - 1; j >= 0; j--) {
				map[i][j] = s2.charAt(idx++) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
