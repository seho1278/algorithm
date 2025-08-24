import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 데이크스트라
 * 단방향 그래프
 * 시작 노드에서 각 정점으로 이동하는 최소거리 구하기
 * 자기 자신은 0
 * 이동 못하면 INF
 * 
 * 이동하려는 정점과 정점까지의 거리를 같이 관리해야한다.
 * 우선순위 큐에서 최솟값을 뽑아내기 위한 기준을 설정하는 것이 포인트
 */

public class Main {
	// 2차원 배열을 만들어 관리하게 될 경우 30만x30만은 많은 공간을 잡아먹게 됨
	static Map<Integer, List<Node>> graph;
	static PriorityQueue<Node> queue;
	// boolean 배열 없이 result 배열만으로 충분
	static int[] result;
	
	// Node 객체를 만들어 정점과 이동비용을 관리
	static class Node implements Comparable<Node> {
		int ver;
		int cost;
		
		public Node(int ver, int cost) {
			this.ver = ver;
			this.cost = cost;
		}

		// 최솟값 비교 기준을 cost로 설정
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
		
		// 시작 정점
		int startVer = Integer.parseInt(br.readLine());
		
		graph = new HashMap<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if (graph.get(start) == null) {
				graph.put(start, new ArrayList<>());
			}
			
			graph.get(start).add(new Node(end, d));
		}
		
		// 결과 출력용 (0번 인덱스 사용 x)
		result = new int[V+1];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.MAX_VALUE;
		}
		
		djikstra(startVer);
		
		StringBuilder sb = new StringBuilder();
		
		// StringBuilder 에 각 정점 방문 최소횟수 한번에 입력
		for (int i = 1; i < result.length; i++) {
			if (result[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(result[i]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void djikstra(int startVer) {
		queue = new PriorityQueue<>();
		// 시작 노드 처리 후 queue에 add
		result[startVer] = 0;
		queue.add(new Node(startVer, 0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int nowVer = cur.ver;
			int cost = cur.cost;
			
			// 이미 처리된 정보면 다음으로
			if (result[nowVer] < cost) {
				continue;
			}
			
			// 인접지역 없음 다음으로
			if (graph.get(nowVer) == null) {
				continue;
			}
			
			for (Node nodeNext : graph.get(nowVer)) {
				int next = nodeNext.ver;
				int nextCost = cost + nodeNext.cost;
				
				// 더 짧은 경로를 발견한 경우
				if (nextCost < result[next]) {
					// 갱신 후
					result[next] = nextCost;
					// 큐에 추가
					queue.add(new Node(next, nextCost));
				}
			}
		}
	}
}
