import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/** 
 * 최소비용 구하기
 */
public class Main {
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
	
	static int V, E;
	static List<List<Node>> graph;
	static int[] dist;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		dist = new int[V + 1];
		Arrays.fill(dist, INF);
		
		graph = new ArrayList<>();
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start, end);
		
		System.out.println(dist[end]);
	}
	
	public static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int u = cur.v;
			int w = cur.w;
			
			if (dist[u] < w) {
				continue;
			}
			
			if (u == end) {
				return;
			}
			
			for (Node node: graph.get(u)) {
				int newW = w + node.w;
				if (dist[node.v] > newW) {
					dist[node.v] = newW;
					pq.offer(new Node(node.v, newW));
				}
			}
		}
	}
}
