package baekjoon5567;

import java.io.*;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer>[] tree;
	static int V,E;
	static boolean[] checkNode;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = stoi(br.readLine());
		E = stoi(br.readLine());
		
		tree = new ArrayList[V+1];
		checkNode = new boolean[V+1];
		
		for(int i=1; i<=V; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			String[] s = br.readLine().split(" ");
			int sNum = stoi(s[0]);
			int eNum = stoi(s[1]);
			tree[sNum].add(eNum);
			tree[eNum].add(sNum);
		}
		
		dfs(1,-1,0); // 방문 노드 , 부모 노드, depth
		
		int ans = 0;
		for(int i=1; i<=V; i++) {
			if(checkNode[i]) {
				ans++;
			}
		}
		System.out.println(ans);
		
		
	}
	
	public static void dfs(int start, int parent, int depth) {
		
		for(int next : tree[start]) {
			if(depth>1) break;
			if(next!=parent) {
			dfs(next, start, depth+1);
			checkNode[next]=true;
		}
		}
		
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
