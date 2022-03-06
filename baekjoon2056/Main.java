package baekjoon2056;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

class working implements Comparable<working>{
	int work;
	int time;
	public working(int work, int time) {
		super();
		this.work = work;
		this.time = time;
	}
	@Override
	public int compareTo(working o) {
		return this.time - o.time;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = stoi(br.readLine());
		int ans = 0;
		int indegree[] = new int[N+1];
		working[] worker = new working[N+1];
		
		ArrayList<ArrayList<Integer>> work = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			work.add(new ArrayList<>());
		}
		
		for(int i=1; i<=N; i++) {
			String[] s = br.readLine().split(" ");
			int child = i;
			worker[i] = new working(i,stoi(s[0])); // 자식 노드, 시간 순으로 담는다.
			if(stoi(s[1])!=0) {
			for(int j=2; j<2+stoi(s[1]); j++) {
				work.get(stoi(s[j])).add(child); // 부모 노드 연결시켜줌.
				indegree[child]++;
			}
			}
		}
		
		PriorityQueue<working> pq = new PriorityQueue<>();
		
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0) {
				pq.add(worker[i]); // 부모 노드가 0인 애들 전부 우선순위 큐에 담아줌.
			}
		}
		
		while(!pq.isEmpty()) {
			working w = pq.poll();
			int cur = w.work;
			ans = cur;
			
			for(int next : work.get(cur)) {
				indegree[next]--;
				
				if(indegree[next]==0) {
					worker[next].time += worker[cur].time;
					pq.add(new working(next, worker[next].time));
				}
			}
		}
		System.out.println(worker[ans].time);
		
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
