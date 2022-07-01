package baekjoon1963;

import java.io.*;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

class prime {
	int num;
	int cnt;

	public prime(int num, int cnt) {
		super();
		this.num = num;
		this.cnt = cnt;
	}
}

public class Main {
	static int B, ans;
	static boolean[] visited;
	static boolean[] isPrime = new boolean[10000];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = stoi(br.readLine());

		for (int i = 1; i <= 9999; i++) {
			if (checkPrime(new BigInteger(String.valueOf(i)))) {
				isPrime[i] = true;
			}
		}

		for (int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			int A = stoi(s[0]);
			B = stoi(s[1]);
			ans = Integer.MAX_VALUE;
			visited = new boolean[100000];
			solve(A);
			sb.append(ans).append("\n");
		}

		System.out.println(sb.toString());
	}

	static void solve(int A) {
		Queue<prime> q = new LinkedList<>();
		q.add(new prime(A, 0));

		while (!q.isEmpty()) {
			prime p = q.poll();

			if (p.num == B) {
				ans = Math.min(ans, p.cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {

				for (int j = 0; j <= 9; j++) {
					StringBuilder s = new StringBuilder(String.valueOf(p.num));
					s.setCharAt(i, (char) (j + '0'));
					int next = Integer.parseInt(s.toString());

					if (!thoudCheck(next) || !isPrime[next])
						continue;
					if (!visited[next]) {
						visited[next] = true;
						q.add(new prime(next, p.cnt + 1));
					}
				}
			}

		}

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static boolean thoudCheck(int N) {
		if (N >= 1000 && N <= 9999)
			return true;
		else
			return false;
	}

	static boolean checkPrime(BigInteger number) {
		if (number.isProbablePrime(3)) {
			return true;
		} else
			return false;
	}

}
