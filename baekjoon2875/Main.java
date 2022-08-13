package baekjoon2875;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int N = stoi(s[0]);
		int M = stoi(s[1]);
		int K = stoi(s[2]);
		int cnt = 0;

		while (N >= 2 && M >= 1 && N + M >= 3 + K) {
			N = N - 2;
			M = M - 1;
			cnt++;
		}

		System.out.println(cnt);

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
