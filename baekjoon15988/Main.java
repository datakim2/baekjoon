package baekjoon15988;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = stoi(br.readLine());

		long[] dp = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= 1000000; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
		}

		for (int i = 0; i < T; i++) {
			int n = stoi(br.readLine());
			sb.append(dp[n]).append("\n");
		}

		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
