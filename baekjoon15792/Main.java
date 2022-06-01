package baekjoon15792;

import java.io.*;
import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		System.out.println(new BigDecimal(s[0]).divide(new BigDecimal(s[1]), 1000, BigDecimal.ROUND_HALF_UP));
	}

}
