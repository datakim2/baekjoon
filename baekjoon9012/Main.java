package baekjoon9012;

import java.io.*;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = stoi(br.readLine());
		
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for(int j=0; j<word.length(); j++) {
				if(!stack.isEmpty()) {
					
					if(stack.peek()=='(') {
						
						if(word.charAt(j)==')') stack.pop();
						
						else stack.push(word.charAt(j));
					}else {
						stack.push(word.charAt(j));
					}
					
				}else
				stack.push(word.charAt(j));
				
			}
			if(stack.size()==0) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
