import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최소 신장 그래프
 * 가중치 합 최소 구하기
 * 
 * 크루스칼 알고리즘
 * union-find 이해
 */
public class Main {
		
	static class Node implements Comparable<Node> {
		int a;
		int b;
		int cost;
		
		public Node(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		// 부모 노드 초기화
		int[] parent = new int[V + 1];
		
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		int result = 0;
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// 간선 정보 입력
			queue.add(new Node(a, b, cost));
		}
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			
			int rootA = find(parent, cur.a);
			int rootB = find(parent, cur.b);
			
			// 각 find 결괏값이 다른 경우 두 노드를 합하고 result에 비용 더하기
			if (rootA != rootB) {
				union(parent, rootA, rootB);
				result += cur.cost;
			}
		}
		
		System.out.println(result);
		
	}
	
	// 부모 노드를 탐색하면서 다음 탐색시 바로 가져올 수 있게 압축(O(a(N)))
	public static int find(int[] parent, int x) {
		if (parent[x] != x) {
			parent[x] = find(parent, parent[x]);
		}
		return parent[x];
	}
	
	public static void union(int[] parent, int rootA, int rootB) {
		// 낮은쪽이 부모가 되도록 설정		
		if (rootA < rootB) {
			parent[rootB] = rootA;
		} else {
			parent[rootA] = rootB;
		}
	}
}
