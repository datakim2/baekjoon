package baekjoon18409;

import java.io.*;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = stoi(br.readLine());

		HashSet<Character> vowels = new HashSet<>();
		
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');

		String word = br.readLine();
		int ans = 0;

		for (int i = 0; i < N; i++) {
			if (vowels.contains(word.charAt(i))) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
