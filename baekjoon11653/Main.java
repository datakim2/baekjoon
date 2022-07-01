package baekjoon11653;

import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = stoi(br.readLine());

		while (true) {

			for (int i = 2; i <= N; i++) {
				if (N % i == 0) {
					BigInteger check = new BigInteger(String.valueOf(i));
					if (check.isProbablePrime(10)) {
						N = N / i;
						sb.append(i).append("\n");
						break;
					} else {
						break;
					}
				}
			}
			if (N == 1) {
				break;
			}
		}

		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
