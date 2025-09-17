import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 택배 배송
 * 다익스트라 복습
 * 
 * 양방향 간선
 * 음수 가중치 x
 * 1부터 N까지 최단거리 구하기
 */
public class Main {
	
	static List<List<Node>> graph;
	static int N, E;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	
	static class Node implements Comparable<Node> {
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, w));
			graph.get(v).add(new Node(u, w));
		}
		
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dijkstra(1);
		
		System.out.println(dist[N]);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int u = cur.v;
			int d = cur.w;
			
			if (dist[u] < d) {
				continue;
			}
			
			if (u == N) {
				break;
			}
			
			for (Node node: graph.get(u)) {
				int newD = d + node.w;
				if (dist[node.v] > newD) {
					dist[node.v] = newD;
					pq.offer(new Node(node.v, newD));
				}
			}
		}
		
	}
}
