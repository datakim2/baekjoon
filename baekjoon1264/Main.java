package baekjoon1264;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String word = br.readLine();

			if (word.equals("#")) {
				break;
			}

			int vow = 0;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);

				if (c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
			|| c == 'A' || c=='I' || c=='E' || c=='O' || c=='U') {
					vow++;
				}
			}
			sb.append(vow).append("\n");
		}

		System.out.println(sb.toString());
	}

}
