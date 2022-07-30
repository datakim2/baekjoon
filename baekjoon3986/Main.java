package baekjoon3986;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = stoi(br.readLine());
		Stack<Character> stack = new Stack<>();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			String word = br.readLine();

			stack = new Stack<>();
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				
				if (!stack.isEmpty() && stack.peek() == c)
					stack.pop();
				else
					stack.push(c);

			}
			
			if (stack.size() == 0)
				cnt++;
		}
		System.out.println(cnt);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
