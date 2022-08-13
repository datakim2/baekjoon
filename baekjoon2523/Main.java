package baekjoon2523;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = stoi(br.readLine());
		
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<=i; j++)
			System.out.print("*");
			
			System.out.println();
		}
		for(int i=N-1; i>0; i--) {
			
			for(int j=0; j<i; j++)
				System.out.print("*");
			
			System.out.println();
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
