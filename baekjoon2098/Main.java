package baekjoon2098;

import java.io.*;
import java.util.Arrays;

public class Main {
	static int[][] dp;
	static int[][] map;
	static int N;
	static final int INF = 32_000_000_0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = stoi(br.readLine());
		map = new int[N][N];
		dp = new int[N][1 << N];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(s[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], INF);
		}

		System.out.println(TSP(0, 1));

	}

	public static int TSP(int cur, int visit) {

		if (visit == (1 << N) - 1) { // 모든 도시 방문했을때
			if (map[cur][0] == 0) { // 출발점으로 갈 수 없을때
				return INF;
			} else {
				return map[cur][0]; // 출발점으로 갈 수 있을때
			}
		}

		if (dp[cur][visit] != INF)
			return dp[cur][visit];

		for (int i = 0; i < N; i++) {
			if ((visit & (1 << i)) != 0 || map[cur][i] == 0)
				continue;
			// visit & (1<<i) != 0 이면 이미 방문한 도시라는 말이다.
			// map[cur][i] == 0 이면 방문할 길이 없다는 말이다.

			dp[cur][visit] = Math.min(dp[cur][visit], map[cur][i] + TSP(i, visit | (1 << i)));
			// i번 도시 방문 후 visit에 or 연산으로 방문한 상태 추가하여 dfs 실행

		}

		return dp[cur][visit];

	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
