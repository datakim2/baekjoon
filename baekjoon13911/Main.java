package baekjoon13911;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	long e;
	long w;

	public Node(long e, long w) {
		super();
		this.e = e;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		if (this.w > o.w)
			return 1;
		else if (this.w == o.w)
			return 0;
		else
			return -1;
	}
}

public class Main {
	static int V, E;
	static ArrayList<Node>[] graph;
	static final long INF = 3000000000L;
	static long distMin = INF;
	static PriorityQueue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		V = stoi(s[0]);
		E = stoi(s[1]);

		graph = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			String[] s2 = br.readLine().split(" ");
			int sNum = stoi(s2[0]);
			int eNum = stoi(s2[1]);
			int wNum = stoi(s2[2]);
			graph[sNum].add(new Node(eNum, wNum));
			graph[eNum].add(new Node(sNum, wNum));
		}
		String[] s3 = br.readLine().split(" ");
		int MacNum = stoi(s3[0]);
		int MacK = stoi(s3[1]);
		long[] Mac = new long[MacNum];
		String[] s4 = br.readLine().split(" ");
		for (int i = 0; i < MacNum; i++) {
			Mac[i] = stoi(s4[i]);
		}
		String[] s5 = br.readLine().split(" ");
		int starNum = stoi(s5[0]);
		int starK = stoi(s5[1]);
		long[] star = new long[starNum];
		String[] s6 = br.readLine().split(" ");
		for (int i = 0; i < starNum; i++) {
			star[i] = stoi(s6[i]);
		}

		long[] distMac = new long[V + 1];
		long[] distStar = new long[V + 1];
		Arrays.fill(distMac, INF);
		Arrays.fill(distStar, INF);
		
		for(int i=0; i<MacNum; i++) {
			distMac[(int) Mac[i]] = 0;
			pq.add(new Node(Mac[i], 0));
		}
		
		djikstra(distMac);
		
		for(int i=0; i<starNum; i++) {
			distStar[(int) star[i]] = 0;
			pq.add(new Node(star[i], 0));
		}
		djikstra(distStar);
		
		for(int i=1; i<=V; i++) {
			if(distMac[i]>0 && distMac[i]<=MacK && distStar[i]>0 && distStar[i]<=starK) {
				distMin = Math.min(distMin, distMac[i]+distStar[i]);
			}
		}
		if(distMin==INF) {
			System.out.println(-1);
		}
		else {
		System.out.println(distMin);
	}
	}

	public static void djikstra(long[] dist) {
		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			long cur = curNode.e;
				
			for(int i=0; i<graph[(int)curNode.e].size(); i++) {
					Node next =  graph[(int)cur].get(i);
				if (dist[(int) next.e] > next.w + curNode.w) {
					dist[(int) next.e] = next.w + curNode.w;
					pq.add(new Node(next.e, dist[(int) next.e]));
				}
		}
		}
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
