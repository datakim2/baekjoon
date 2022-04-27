package baekjoon12931;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = stoi(br.readLine());

		int[] arr = new int[n];

		String[] s = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = stoi(s[i]);
		}

		int cnt = 0;

		while (true) {
			boolean isOdd = false;
			for (int i = 0; i < n; i++) {
				if (arr[i] % 2 != 0) {
					arr[i]--;
					cnt++;
					isOdd = true;
				}
			}
			if (!isOdd) {
				boolean check = false;
				for (int i = 0; i < n; i++) {
					if (arr[i] == 0)
						continue;
					arr[i] = arr[i] / 2;
					check = true;
				}
				if (check) {
					cnt++;
				}
			}

			boolean isAnswer = true;

			for (int i = 0; i < n; i++) {
				if (arr[i] != 0) {
					isAnswer = false;
					break;
				}
			}

			if (isAnswer) {
				System.out.println(cnt);
				System.exit(0);
			}
		}
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
