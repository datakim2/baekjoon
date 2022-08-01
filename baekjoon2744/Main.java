package baekjoon2744;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		
		String newWord = "";
		
		for(int i=0; i<word.length(); i++) {
			if(word.charAt(i)-'a'>=0 && word.charAt(i)-'a'<=25) {
				newWord +=String.valueOf(word.charAt(i)).toUpperCase();
			}else {
				newWord +=String.valueOf(word.charAt(i)).toLowerCase();
			}
		}
		
		System.out.println(newWord);
		
	}

}
