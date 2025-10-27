import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
	
	static int n, m, r;
	static int[] items;
	static List<List<Node>> graph;
	static int result;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		items = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, d));
			graph.get(v).add(new Node(u, d));
		}
		
		result = 0;
		
		for (int i = 1; i <= n; i++) {
			dijkstra(i);
		}
		
		System.out.println(result);
	}
	
	public static void dijkstra(int start) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		
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
				int newD = node.d + d;
				if (newD > m) {
					continue;
				}
				
				if (dist[node.v] > newD) {
					dist[node.v] = newD;
					pq.offer(new Node(node.v, newD));
				}
			}
		}
		
		check(dist);
	}
	
	public static void check(int[] arr) {
		int sum = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != INF) {
				sum += items[i - 1];
			}
		}
		
		result = Math.max(result, sum);
	}
}
