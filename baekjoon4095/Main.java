package baekjoon4095;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {

			String[] s = br.readLine().split(" ");
			int N = stoi(s[0]);
			int M = stoi(s[1]);

			if (N == 0 && M == 0)
				break;

			int[][] dp = new int[N + 1][M + 1];
			int ans = -1;

			for (int i = 1; i <= N; i++) {
				String[] s2 = br.readLine().split(" ");
				for (int j = 1; j <= M; j++) {
					int temp = stoi(s2[j - 1]);

					if (temp == 1)
						dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
					
					ans = Math.max(dp[i][j], ans);
				}
			}


			sb.append(ans).append("\n");

		}
		System.out.println(sb.toString());

	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
