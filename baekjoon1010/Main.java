package baekjoon1010;

import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = stoi(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");

			int a = stoi(s[0]);
			int b = stoi(s[1]);
			BigInteger one = new BigInteger("1");
			BigInteger two = new BigInteger("1");

			for (int i = b - a + 1; i <= b; i++) {
				one = one.multiply(new BigInteger(Integer.toString(i)));
			}

			for (int i = 1; i <= a; i++) {
				two = two.multiply(new BigInteger(Integer.toString(i)));
			}
			sb.append(one.divide(two)).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
