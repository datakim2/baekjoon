package baekjoon1926;

import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N,M;
	static int[][]map;
	static int cnt,ans,max;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for(int i=1; i<=N; i++) {
			String[] s2= br.readLine().split(" ");
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(s2[j-1]);
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					visited[i][j] = true;
					bfs(i,j);
					ans++;
				}
			}
		}
		if(ans==0) {
			System.out.println(0);
			System.out.println(0);
		}
		else {
		System.out.println(ans);
		System.out.println(max);
	}
	}
	
	public static void bfs(int x0, int y0) {
		Queue<Point> q =new LinkedList<>();
		q.add(new Point(x0, y0));
		cnt = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0; i<4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				
				if(x>=1 && y>=1 && x<=N && y<=M && map[x][y]==1) {
					if(!visited[x][y]) {
						visited[x][y] = true;
						cnt++;
						q.add(new Point(x,y));
					}
				}
			}
		}
		max = Math.max(cnt, max);
	}

}
