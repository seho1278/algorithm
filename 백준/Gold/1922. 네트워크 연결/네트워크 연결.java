import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 네트워크 연결
 * 
 * 크루스칼 알고리즘을 사용한 mst 구현 로직 작성
 * 문제 풀이 후
 * 
 * 일반 bfs 탐색으로도 문제가 풀리는지 확인 (시간초과나 메모리초과가 발생하긴 할듯)
 * 
 * 컴퓨터 수 V (1 <= V <= 1,000)
 * 연결 선의 수 E (1 <= E <= 100,000)
 */
public class Main {
	static int V, E;
	
	static class Node implements Comparable<Node> {
		int u;
		int v;
		int w;
		
		public Node(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		// 0번 인덱스 사용 x
		int[] parent = new int[V + 1];
		
		// 처음은 자기 자신이 parent로 설정
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		// 가중치(w)가 작은게 먼저 나오도록 설정(Node class 구현)
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int result = 0;
		int cnt = 0;
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			pq.offer(new Node(u, v, w));
		}
		
		while (!pq.isEmpty()) {
			// 종료 조건 설계
			if (cnt == V - 1) {
				// mst는 연결되는 간선의 개수가 V-1개여야한다.
				break;
			}
			
			Node cur = pq.poll();
			
			// 각각의 root node 탐색
			int rootU = find(parent, cur.u);
			int rootV = find(parent, cur.v);
			
			// 사이클 유무 확인
			if (rootU != rootV) {
				// 두 V의 root가 다르면 사이클 x 합쳐주기
				union(parent, rootU, rootV);
				result += cur.w;
				cnt++;
			}
		}
		
		System.out.println(result);
	}
	
	// union-find를 통해 사이클 탐색시간 최소화
	public static int find(int[] parent, int x) {
		if (parent[x] != x) {
			return parent[x] = find(parent, parent[x]);
		}
		
		// 최종 루트 노드 반환
		return parent[x];
	}
	
	public static void union(int[] parent, int rootU, int rootV) {
		// 낮은쪽이 root가 되도록 설계
		if (rootU > rootV) {
			parent[rootU] = rootV;
		} else {
			parent[rootV] = rootU;
		}
	}
}
