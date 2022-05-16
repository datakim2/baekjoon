package baekjoon9625;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] A = new long[46];
		long[] B = new long[46];

		int N = Integer.parseInt(br.readLine());

		A[0] = 1;
		B[0] = 0;

		A[1] = 0;
		B[1] = 1;

		for (int i = 2; i <= N; i++) {
			A[i] = A[i - 1] + A[i - 2];
			B[i] = B[i - 1] + B[i - 2];
		}

		System.out.println(A[N] + " " + B[N]);
	}

}
