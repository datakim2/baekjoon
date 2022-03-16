package baekjoon20055;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, K;
	static int[] map;
	static boolean[] robot;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		N = stoi(s[0]);
		K = stoi(s[1]);

		map = new int[2 * N + 1];
		robot = new boolean[2 * N + 1];

		String[] s2 = br.readLine().split(" ");

		for (int i = 1; i <= 2 * N; i++) {
			map[i] = stoi(s2[(i - 1)]);
		}

		int ans = 0;

		while (true) {
			ans++;
			rotate();
			robotMove();
			if (zeroCheck())
				break;
		}
		System.out.println(ans);

	}

	public static void rotate() {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 2*N-1; i >=1; i--) {
			q.add(map[i]);
		}

		map[1] = map[2 * N];

		for (int i = 2*N ; i >=2; i--) {
			map[i] = q.poll();
		}

		Queue<Boolean> q2 = new LinkedList<>();

		for (int i = N-1; i >=1; i--) {
			q2.add(robot[i]);
		}

		for (int i = N; i >= 2; i--) {
			robot[i] = q2.poll();
		}

		if (robot[N]) {
			robot[N] = false; // 로봇 내리기
		}
		
		robot[1] = false;
	}

	public static void robotMove() {

		if (robot[N]) {
			robot[N] = false; // 로봇 내리기
		}
		
		for (int i = N - 1; i >= 1; i--) {
			if (robot[i] && !robot[i + 1] && map[i + 1] >= 1) { // 이번칸 로봇이 있고, 다음칸에 로봇이 없고, 내구성이 0보다 크면 이동
				robot[i] = false;
				robot[i + 1] = true;
				map[i + 1]--; // 내구성 1 감소
			}
		}
		
		if (map[1] > 0 && !robot[1]) {
			robot[1] = true;
			map[1]--;
		}
	}

	public static boolean zeroCheck() {
		int cnt = 0;
		for (int i = 1; i <= 2 * N; i++) {
			if (map[i] == 0)
				cnt++;
		}
		if (cnt >= K)
			return true;
		else
			return false;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
