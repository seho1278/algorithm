import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 선수 과목 (위상 정렬)
 * 모든 전공과목을 듣고 졸업
 * 어떤 과목들은 선수과목이 있음 -> 먼저 이수해야 진행 가능
 * 계산을 편리하기 위해 조건을 만들어 간소화
 * 1. 한 학기 들을 수 있는 과목 수 제한 x
 * 2. 모든 과목은 매 학기 항상 개설됨
 * 
 * 모든 과목에 대해 각 과목을 이수하려면 최소 몇 학기가 걸리는지 계산하는 프로그램
 *  
 * 첫 줄에 과목수와 선수조건 수
 * 선수 과목은
 * A B 형태로 주어짐 A가 B의 선수과목임
 */

public class Main {
	static int V, E;
	static int[] major;
	static int[] result;
	static Map<Integer, List<Integer>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 진입 차수 기록
		major = new int[V + 1];
		graph = new HashMap<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			// 진입차수 기록
			major[v]++;
			
			if (graph.get(u) == null) {
				graph.put(u, new ArrayList<>());
			}
			
			graph.get(u).add(v);
		}
		
		result = new int[V + 1];
		
		bfs();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= V; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void bfs() {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= V; i++) {
			if (major[i] == 0) {
				queue.offer(i);
			}
		}
		
		int semester = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			semester++;
			
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				
				result[cur] = semester; 
				
				List<Integer> next;
				
				// 과목의 진출차수를 탐색
				if (graph.get(cur) == null) {
					continue;
				} else {
					next = graph.get(cur);
				}
				
				for (int j = 0; j < next.size(); j++) {
					int u = next.get(j);
					major[u]--;
					if (major[u] == 0) {
						queue.add(u);
					}
				}
			}
		} // while
	} // bfs
}
