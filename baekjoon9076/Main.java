package baekjoon9076;

import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = stoi(br.readLine());

		for (int i = 0; i < N; i++) {
			int[] arr = new int[5];
			String[] s = br.readLine().split(" ");

			for (int j = 0; j < 5; j++) {
				arr[j] = stoi(s[j]);
			}

			Arrays.sort(arr);
			if (Math.abs(arr[1] - arr[3]) >= 4) {
				sb.append("KIN").append("\n");
			} else
				sb.append(arr[1] + arr[2] + arr[3]).append("\n");
		}

		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
