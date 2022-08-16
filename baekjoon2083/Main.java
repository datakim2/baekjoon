package baekjoon2083;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {

			String[] s = br.readLine().split(" ");

			if (s[1].equals("0") && s[2].equals("0"))
				break;

			if (stoi(s[1]) > 17 || stoi(s[2]) >= 80)
				sb.append(s[0] + " " + "Senior").append("\n");
			else
				sb.append(s[0] + " " + "Junior").append("\n");

		}
		
		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
