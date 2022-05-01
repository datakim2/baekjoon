package baekjoon19944;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		if(M==1 || M==2) {
			System.out.println("NEWBIE!");
		}else {
			if(M<=N) {
				System.out.println("OLDBIE!");
			}
			else {
				System.out.println("TLE!");
			}
		}
	}

}
