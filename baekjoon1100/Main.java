package baekjoon1100;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		
		for(int i=0; i<8; i++) {
			String[] s = br.readLine().split("");
			
			if(i%2==0) {
			for(int j=0; j<8; j=j+2) {
				if(s[j].equals("F")) cnt++;
			}
			}
			else {
				for(int j=1; j<8; j=j+2) {
					if(s[j].equals("F")) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
