package baekjoon1526;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = stoi(br.readLine());

		for (int i = n; i > 0; i--) {

			if (String.valueOf(i).contains("1") || String.valueOf(i).contains("2") || String.valueOf(i).contains("3")
					|| String.valueOf(i).contains("5") || String.valueOf(i).contains("6")
					|| String.valueOf(i).contains("8") || String.valueOf(i).contains("9")
					|| String.valueOf(i).contains("0")) {
				continue;
			}

			System.out.println(i);
			break;
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
