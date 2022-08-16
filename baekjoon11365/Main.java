package baekjoon11365;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		while (true) {

			String word = br.readLine();

			if (word.equals("END"))
				break;

			sb2.append(sb.append(word).reverse()).append("\n");
			sb = new StringBuilder();

		}

		System.out.println(sb2.toString());

	}

}
