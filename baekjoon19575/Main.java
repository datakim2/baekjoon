package baekjoon19575;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int A = stoi(s[0]);
		int B = stoi(s[1]);
		
		int a = A%10*100+(A%100)/10*10+A/100;
		int b = B%10*100+(B%100)/10*10+B/100;
		
		System.out.println(Math.max(a, b));

	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}



}
