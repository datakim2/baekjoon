package baekjoon9325;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = stoi(br.readLine());

		for (int i = 0; i < N; i++) {

			int money = stoi(br.readLine());
			int T = stoi(br.readLine());

			int add = 0;
			for (int j = 0; j < T; j++) {
				String[] s = br.readLine().split(" ");
				int a = stoi(s[0]);
				int b = stoi(s[1]);

				add += a * b;
			}

			money += add;
			sb.append(money).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
