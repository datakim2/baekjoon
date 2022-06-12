package baekjoon10103;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = 100;
		int B = 100;

		int N = stoi(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			int A1 = stoi(s[0]);
			int B1 = stoi(s[1]);
			if (A1 > B1) {
				B -= A1;
			} else if (A1 < B1) {
				A -= B1;
			}
		}

		System.out.println(A);
		System.out.println(B);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
