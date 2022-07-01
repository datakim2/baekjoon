package baekjoon1247;

import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			int T = stoi(br.readLine());
			BigInteger sum = new BigInteger("0");
			for (int j = 0; j < T; j++) {
				sum = sum.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
			}
			if (sum.signum() > 0) {
				sb.append("+").append("\n");
			} else if (sum.signum() < 0) {
				sb.append("-").append("\n");
			} else {
				sb.append("0").append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
