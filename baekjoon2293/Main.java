package baekjoon2293;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		int N = stoi(s[0]);
		int K = stoi(s[1]);

		int[] arr = new int[N + 1];
		int[] dp = new int[K + 1];
		dp[0] = 1;

		for (int i = 1; i <= N; i++) {
			arr[i] = stoi(br.readLine());
			for (int j = arr[i]; j <= K; j++) {
				dp[j] += dp[j - arr[i]];
			}
		}

		System.out.println(dp[K]);

	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
