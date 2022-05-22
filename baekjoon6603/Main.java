package baekjoon6603;

import java.io.*;
import java.util.ArrayList;

public class Main {
	static int N;
	static boolean visited[];
	static ArrayList<Integer> lotto;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] s = br.readLine().split(" ");

			if (stoi(s[0]) == 0)
				break;

			N = stoi(s[0]);
			visited = new boolean[N];

			lotto = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				lotto.add(stoi(s[i]));
			}

			dfs(0, 0);
			System.out.println();
		}
	}

	static void dfs(int idx, int cnt) {

		if (cnt == 6) {
			for (int i = 0; i < N; i++)
				if (visited[i]) {
					System.out.print(lotto.get(i) + " ");
				}
			System.out.println();
			return;
		}

		for (int i = idx; i < N; i++) {
			visited[i] = true;
			dfs(i + 1, cnt + 1);
			visited[i] = false;
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
