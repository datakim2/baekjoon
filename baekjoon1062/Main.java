package baekjoon1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] visited;
	static String[] word;
	static int N, K;
	static int max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		visited = new boolean['z' + 1];
		word = new String[N + 1];

		if (K < 5) {
			System.out.println(0);
			System.exit(0);
		}

		visited['a'] = true;
		visited['n'] = true;
		visited['t'] = true;
		visited['i'] = true;
		visited['c'] = true;

		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
		}

		backTracking('a', 0);

		System.out.println(max);

	}

	static void backTracking(int idx, int len) {
		if (len == K - 5) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				boolean read = true;
				for (int j = 0; j < word[i].length(); j++) {
					if (!visited[word[i].charAt(j)]) {
						read = false;
						break;
					}
				}

				if (read)
					cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}

		for (int i = idx; i <= 'z'; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				backTracking(i, len + 1);
				visited[i] = false;
			}
		}
	}

}
