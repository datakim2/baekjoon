package baekjoon2629;

import java.io.*;

public class Main {
	static int N, M; // 각각 추 개수, 구슬 개수
	static int[] w; // 추 무게를 담을 배열
	static int[] mw; // 구슬 무게를 담을 배열
	static boolean[][] used; // 사용한 추 구분
	static boolean isPossible = false; // 정답이 가능한지 여부 판별
	static StringBuilder sb = new StringBuilder(); // 정답을 저장할 StringBuilder 선언

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼 입출력

		N = stoi(br.readLine()); // 추 개수
		String[] s = br.readLine().split(" "); // 추 무게 저장
		w = new int[N + 1]; // 추 무게를 담을 배열
		used = new boolean[N + 1][15001]; // 추 무게를 담을 배열

		for (int i = 1; i <= N; i++) {
			w[i] = stoi(s[i - 1]); // 추 무게 저장
		}

		M = stoi(br.readLine()); // 구슬 개수
		mw = new int[M + 1]; // 구슬 무게 담을 배열

		String[] s2 = br.readLine().split(" "); // 구슬 무게 저장
		for (int i = 0; i < M; i++) {
			mw[i] = stoi(s2[i]); // 구슬 무게 저장
		}

		solve(0, 0); // 구슬 무게 미리 구함

		for (int i = 0; i < M; i++) {

			if (mw[i] > 15000) {
				sb.append("N "); // 구슬의 무게가 15000을 넘어가면 500g짜리 추 30개를 모두 사용하여도 무게를 알 수 없으므로 N 저장
				continue;
			}

			if (used[N][mw[i]]) { // 무게를 잴 수 있을 경우 Y 저장, 없을 경우 N 저장
				sb.append("Y ");
			} else {
				sb.append("N ");
			}
		}

		System.out.println(sb.toString());

	}

	public static void solve(int idx, int weight) {

		if (used[idx][weight])
			return;
		used[idx][weight] = true;

		if (idx == N) {
			return;
		}

		solve(idx + 1, weight + w[idx + 1]);
		solve(idx + 1, weight);
		solve(idx + 1, Math.abs(weight - w[idx + 1]));
	}

	public static int stoi(String s) {
		return Integer.parseInt(s); // String to int
	}

}