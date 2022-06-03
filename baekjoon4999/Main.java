package baekjoon4999;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();

		if (s2.length() >= s1.length())
			System.out.println("no");
		else
			System.out.println("go");
	}

}
