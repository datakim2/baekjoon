package baekjoon4949;

import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {

			String s = br.readLine();

			if (s.length() == 1 && s.equals("."))
				break;

			Stack<Character> stack = new Stack<>();
			boolean isPossible = true;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					stack.push(s.charAt(i));
				} else if (s.charAt(i) == ')') {
					if (!stack.isEmpty()) {
						if (stack.peek() == '(') {
							stack.pop();
						} else {
							isPossible = false;
							break;
						}
					} else {
						isPossible = false;
						break;
					}
				}
				if (s.charAt(i) == '[') {
					stack.push(s.charAt(i));
				} else if (s.charAt(i) == ']') {
					if (!stack.isEmpty()) {
						if (stack.peek() == '[') {
							stack.pop();
						} else {
							isPossible = false;
							break;
						}
					} else {
						isPossible = false;
						break;
					}
				}
			}
			
			if(stack.size()>0) isPossible = false;

			if (isPossible)
				sb.append("yes").append("\n");
			else
				sb.append("no").append("\n");
		}

		System.out.println(sb.toString());

	}
}
