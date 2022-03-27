package baekjoon11948;

import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sumA = 0;
		int sumB = 0;
		int[] arr = new int[6];
		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		sumA = Math.max(arr[0] + arr[1] + arr[2], Math.max(arr[0] + arr[1] + arr[3], arr[0] + arr[2] + arr[3]));
		sumA = Math.max(sumA, arr[1] + arr[2] + arr[3]);
		sumB = Math.max(arr[4], arr[5]);
		System.out.println(sumA + sumB);
	}

}
