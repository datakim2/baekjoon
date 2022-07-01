package baekjoon25305;

import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int N = stoi(s[0]);
		int M = stoi(s[1]);
		String[] s2 = br.readLine().split(" ");

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = stoi(s2[i]);
		}

		Arrays.sort(arr);

		System.out.println(arr[N-M]);

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
