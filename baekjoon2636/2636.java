import java.io.*;

public class Main {
	static int[][] map;
	static int[][] map2;
	static int[][] index;
	static boolean[][] isVisited;
	static int n,m,cnt,cnt2,ans;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		map = new int[n+2][m+2];
		map2 = new int[n+2][m+2];
		index = new int[n+2][m+2];
		isVisited = new boolean[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			String[] s2 = br.readLine().split(" ");
			for(int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(s2[j-1]);
				map2[i][j] = Integer.parseInt(s2[j-1]);
				index[i][j] = 1;
			}
		}
		
		while(true) {
		cnt++;
		if(mapCheck()) break;
		dfs(1,1);
		mapUpdate();
		ans=cnt2;
		isVisited = new boolean[n+1][m+1];
		}
		
		System.out.println(cnt-1);
		System.out.println(ans);
	}
	
	public static void dfs(int x0, int y0) {
		
			for(int i=0; i<4; i++) {
			int x = x0+dx[i];
			int y = y0+dy[i];
			
			if(x>=1 && y>=1 && x<=n && y<=m) {
				if(!isVisited[x][y] && map[x0][y0]==0){
					isVisited[x][y] = true;
				index[x][y]+= index[x0][y0];
				dfs(x,y);
			}
			}
			}
		}
	
	public static void mapUpdate() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(index[i][j]!=1 && map2[i][j]==1) {
					map2[i][j]=0;
				}
				index[i][j]=1;
				map[i][j] = map2[i][j];
			}
		}
		
	}
	
	public static boolean mapCheck() {
		cnt2=0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(map2[i][j]==1) cnt2++;
			}
		}
		if(cnt2>0) return false;
		else return true;
		
	}

}
