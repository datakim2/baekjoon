package baekjoon1668;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = stoi(br.readLine());

		int cnt = 0;
		int cnt2 = 0;

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = stoi(br.readLine());
		}

		int pre = 0;
		for (int i = 0; i < N; i++) {
			int temp = arr[i];
			if (temp > pre) {
				cnt++;
				pre = arr[i];
			}
		}

		pre = 0;
		for (int i = N - 1; i >= 0; i--) {
			int temp = arr[i];
			if (temp > pre) {
				cnt2++;
				pre = temp;
			}
		}

		System.out.println(cnt);
		System.out.println(cnt2);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
