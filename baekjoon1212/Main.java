package baekjoon1212;

import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();

		BigInteger a = new BigInteger(num, 2);
		
		String res = a.toString(8);

		System.out.println(res);

	}

}
