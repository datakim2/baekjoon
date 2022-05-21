package baekjoon5566;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int N = stoi(s[0]);
		int M = stoi(s[1]);
		int[] move = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			move[i] = stoi(br.readLine());
		}
		int[] dice = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			dice[i] = stoi(br.readLine());
		}

		int next = 1;

		for (int i = 1; i <= M; i++) {
			next = next + dice[i];
			if (next >= N) {
				System.out.println(i);
				break;
			}
			int moving = move[next];
			next = next + moving;
			if (next >= N) {
				System.out.println(i);
				break;
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
