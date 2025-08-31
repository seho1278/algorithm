import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 최소 스패닝 트리
 */
public class Solution {
	
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
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			// 부모 초기화
			int[] parent = new int[V + 1];
			
			// 처음엔 자기자신이 부모노드
			for (int i = 1; i <= V; i++) {
				parent[i] = i;
			}
			
			long result = 0;
			
			// ArrayList를 사용하여 간선정보를 입력 받은 뒤 오름차순 정렬하기
			List<Node> arr = new ArrayList<>();
			
			// 간선 정보 입력
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				arr.add(new Node(u, v, w));
			}
			
 	
			// 오름차순 정렬
			Collections.sort(arr);
			
			// cnt가 V-1개가 될때까지 확인
			
			int cnt = 0;
			int idx = 0;
			
			while (cnt < V - 1) {
				Node cur = arr.get(idx);
				
				// 두 정점의 부모 노드 탐색
				int rootU = find(parent, cur.u);
				int rootV = find(parent, cur.v);
				
				// 부모노드가 같지 않아야 합해도 사이클이 되지 않음
				if (rootU != rootV) {
					// 같지 않으면 합하고 가중치 더하기
					result += cur.w;
					union(parent, rootU, rootV);
					cnt++;
				}
				
				idx++;
				
			}
			
			// 출력
			System.out.println("#" + tc + " " + result);
		}
	} // main
	
	// 부모 노드 탐색하면서 바로 부모노드 접근 가능하도록 parent 압축
	public static int find(int[] parent, int x) {
		if (parent[x] != x) {
			parent[x] = find(parent, parent[x]);
		}
		
		// 부모 노드 return
		return parent[x];
	}
	
	// 부모 노드가 낮은 쪽이 부모 노드가 되도록 두 트리를 합하기
	public static void union(int[] parent, int rootU, int rootV) {
		if (rootU > rootV) {
			parent[rootV] = rootU;
		} else {
			parent[rootU] = rootV;
		}
	}

}
