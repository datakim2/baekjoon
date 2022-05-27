package baekjoon2935;

import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BigInteger a = new BigInteger(br.readLine());
		String cal = br.readLine();
		BigInteger b = new BigInteger(br.readLine());

		if (cal.equals("*")) {
			System.out.println(a.multiply(b));
		} else {
			System.out.println(a.add(b));
		}
	}

}