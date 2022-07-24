package baekjoon9295;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = stoi(br.readLine());
		
		for(int i=1; i<=T; i++) {
			String[] s = br.readLine().split(" ");
			sb.append("Case "+i+": "+(stoi(s[0])+stoi(s[1]))).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
