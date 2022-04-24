package baekjoon9465;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = stoi(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = stoi(br.readLine());

			int[][] arr = new int[N + 1][2];
			int[][] dp = new int[N + 1][2];

			for (int j = 0; j <= 1; j++) {
				String[] s = br.readLine().split(" ");
				for (int i = 1; i <= N; i++) {
					arr[i][j] = stoi(s[i - 1]);
				}
			}

			dp[1][0] = arr[1][0];
			dp[1][1] = arr[1][1];

			for (int i = 2; i <= N; i++) {
				dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + arr[i][0];
				dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + arr[i][1];
			}

			System.out.println(Math.max(dp[N][0], dp[N][1]));
		}
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
