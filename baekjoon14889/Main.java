package baekjoon14889;

import java.io.*;

public class Main {
	static int N, min = Integer.MAX_VALUE;
	static int map[][];
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

		comb(0, 0);

		System.out.println(min);
	}

	public static void comb(int idx, int count) {
		if (count == N / 2) {

			calMin(); // 최솟값 계산
			
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(i + 1, count + 1);
				visited[i] = false; // 백트래킹
			}
		}
	}

	public static void calMin() {
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) {
					sum1 += map[i][j] + map[j][i];
				} else if (!visited[i] && !visited[j]) {
					sum2 += map[i][j] + map[j][i];
				}
			}
		}
		int diff = Math.abs(sum1 - sum2);

		if (diff == 0) {
			System.out.println(0);
			System.exit(0);
		}

		min = Math.min(min, diff);

	}

}
