package baekjoon14470;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[5];

		for (int i = 0; i < 5; i++) {
			arr[i] = stoi(br.readLine());
		}

		int sum = 0;

		if (arr[0] < 0) {
			int diff = -arr[0];

			sum += diff * arr[2];
			sum += arr[3];
			sum += arr[1] * arr[4];

		} else {
			sum += (arr[1] - arr[0]) * arr[4];
		}

		System.out.println(sum);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
