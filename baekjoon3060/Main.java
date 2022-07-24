package baekjoon3060;

import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long T = stoi(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			long feed = stoi(br.readLine());
			long sum = 0;
			String[] s = br.readLine().split(" ");

			for (int j = 0; j < 6; j++) {
				sum += stoi(s[j]);
			}

			int day = 1;

			while (sum <= feed) {
				sum *= 4;
				day++;

			}

			sb.append(day).append("\n");

		}

		System.out.println(sb.toString());
	}

	static long stoi(String s) {
		return Long.parseLong(s);
	}

}
