package baekjoon2169;

import java.io.*;

public class Main {
	static int N, M, ans;
	static int[][] dp;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		N = stoi(s[0]);
		M = stoi(s[1]);

		map = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String[] s2 = br.readLine().split(" ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = stoi(s2[j - 1]);
			}
		}

		solve();

	}

	public static void solve() {

		dp[1][1] = map[1][1];

		for (int j = 2; j <= M; j++) {
			dp[1][j] = dp[1][j - 1] + map[1][j];
		}

		int left[], right[];
		for (int i = 2; i <= N; i++) {

			left = new int[M + 1];
			left[0] = dp[i - 1][1];
			for (int j = 1; j <= M; j++) {
				left[j] = Math.max(left[j - 1], dp[i - 1][j]) + map[i][j];
			}

			right = new int[M + 2];
			right[M + 1] = dp[i - 1][M];
			
			for (int j = M; j >= 1; j--) {
				right[j] = Math.max(right[j + 1], dp[i - 1][j]) + map[i][j];
			}

			for (int j = 1; j <= M; j++) {
				dp[i][j] = Math.max(left[j], right[j]);
			}
		}

		System.out.println(dp[N][M]);
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}