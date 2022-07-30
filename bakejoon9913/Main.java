package bakejoon9913;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[10001];
		
		int N = stoi(br.readLine());
		
		int max = -1;
		
		for(int i=0; i<N; i++) {
			int a = stoi(br.readLine());
			
			arr[a]++;
		}
		
		for(int i=0; i<=10000; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		System.out.println(max);
		
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
