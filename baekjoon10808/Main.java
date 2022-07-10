package baekjoon10808;

import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26];
		
		String word = br.readLine();
		
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			
			arr[c-'a']++;
		}
		
		for(int i=0; i<26; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
