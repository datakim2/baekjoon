package baekjoon1252;

import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		BigInteger A = new BigInteger(s[0], 2);
		BigInteger B = new BigInteger(s[1], 2);

		BigInteger sum = A.add(B);
		
		System.out.println(sum.toString(2));

	}

}
