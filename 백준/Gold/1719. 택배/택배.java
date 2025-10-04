import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 택배
 * 집하장에서 다른 집하장으로 최단경로로 화물을 이동시키기 위해 가장 먼저 거처야 하는 집하장이 있음
 * 4행 5열에 6이 있다면 4번에서 5번으로 최단 경로로 가기 위해서는 제일 먼저 6번 집하장으로 이동해야함
 * 
 * 이 때 경로표를 구하는 프로그램 작성
 * 그래프 생성 후
 * 각 정점에서 다익스트라 진행 후 첫번째 이동 정점 추출하기
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
	static final int INF = 987654321;
	static int[][] matrix;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		matrix = new int[V + 1][V + 1];
		
		for (int i = 0; i <= V; i++) {
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
		
		for (int i = 1; i <= V; i++) {
			dijkstra(i);
		}
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j) {
					System.out.print("-" + " ");
				} else {
					System.out.print(matrix[i][j] + " ");					
				}
			}
			System.out.println();
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[V + 1];
		int[] first = matrix[start];
		Arrays.fill(dist, INF);
		
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int u = cur.v;
			int w = cur.w;
			
			if (dist[u] < w) {
				continue;
			}
			
			for (Node node: graph.get(u)) {
				int newW = w + node.w;
				if (dist[node.v] > newW) {
					dist[node.v] = newW;
					if (u == start) {
						first[node.v] = node.v; 
					} else {
						first[node.v] = first[u];
					}
					pq.offer(new Node(node.v, newW));
				}
			}
		}
	}
}
