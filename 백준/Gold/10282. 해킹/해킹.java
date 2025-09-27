import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 해킹
 * 컴퓨터 번호 V
 * 의존성 E
 * 
 */
public class Main {
	
	static class Node implements Comparable<Node> {
		int v;
		int d;
		
		public Node(int v, int d) {
			this.v = v;
			this.d = d;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.d - o.d;
		}
	}
	
	static int V, E, start;
	static List<List<Node>> graph;
	static int[] dist;
	static int infected;
	static int ti;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			for (int i = 0; i < V + 1; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				graph.get(v).add(new Node(u, w));
			}
			
			dijkstra(start);
			
			int count = 0;
			int ti = 0;
			
			for (int i = 1; i <= V; i++) {
				if (dist[i] != Integer.MAX_VALUE) {
					count++;
					if (ti < dist[i]) {
						ti = dist[i];
					}
				}
			}
			
			sb.append(count).append(" ").append(ti).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dijkstra(int start) {
		dist = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Node(start, 0));		
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int u = cur.v;
			int d = cur.d;
			
			if (dist[u] < d) {
				continue;
			}
			
			
			for (Node node: graph.get(u)) {
				int newD = d + node.d;
				if (dist[node.v] > newD) {
					dist[node.v] = newD; 
					pq.offer(new Node(node.v, newD));
				}
			}
		}
	}
}
