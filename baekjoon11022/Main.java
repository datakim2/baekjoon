package baekjoon11022;

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = stoi(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			String[] s = br.readLine().split(" ");
			
			int A = stoi(s[0]);
			int B = stoi(s[1]);
			
			System.out.println("Case #"+tc+": "+A+" + "+B+" = "+(A+B));
		}
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
