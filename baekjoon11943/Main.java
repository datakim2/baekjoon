package baekjoon11943;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		String[] s2 = br.readLine().split(" ");
		
		int A = stoi(s[0]);
		int B = stoi(s[1]);
		int C = stoi(s2[0]);
		int D = stoi(s2[1]);
		
		System.out.println(Math.min(A+D, B+C));
		
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
