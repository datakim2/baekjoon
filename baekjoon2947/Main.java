package baekjoon2947;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] arr;
	static int idx = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		arr = new int[5];

		String[] s = br.readLine().split(" ");

		for (int i = 0; i < 5; i++) {
			arr[i] = stoi(s[i]);
		}

		while (true) {

			boolean reset = true;
			for (int i = idx; i < 4; i++) {
				if (arr[i] > arr[i + 1]) {
					idx = i;
					swap(i, i + 1);
					reset = false;
					break;
				}
			}

			if (reset)
				idx = 0;

			boolean isPossible = true;
			for (int i = 0; i < 4; i++) {
				if (arr[i] > arr[i + 1]) {
					isPossible = false;
					break;
				}
			}

			if (!reset) {
				for (int i = 0; i < 5; i++) {
					sb.append(arr[i] + " ");
				}
				sb.append("\n");
			}
			if (isPossible)
				break;
		}

		System.out.println(sb.toString());
	}

	static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
