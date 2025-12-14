import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 줄세우기
 * N명의 학생들을 키 순서대로 줄을 세움
 * 
 * 두 학생의 키를 비교하는 방법
 * 
 * 키를 비교한 두 학생의 번호 A, B
 * A가 B 앞에 서야하는 의미
 * 
 * 방향 그래프를 만든 후
 * 
 * 위상정렬
 */
public class Main {
	static int N;
	static int M;
	static List<List<Integer>> graph;
	static int[] vertex;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		graph = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		vertex = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			graph.get(A).add(B);
			
			vertex[B]++;
		}
		
		sb = new StringBuilder();
		
		bfs();
		
		System.out.println(sb.toString());
		
	}
	
	public static void bfs() {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		// 진입차수가 0인 정점먼저 입력
		
		for (int i = 1; i <= N; i++) {
			if (vertex[i] == 0) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				sb.append(cur).append(" ");
				
				if (graph.get(cur).size() == 0) {
					continue;
				}
				
				for (int v: graph.get(cur)) {
					if (vertex[v] > 0) {
						vertex[v]--;
						if (vertex[v] == 0) {
							// 진입차수가 0이되면 queue에 추가
							queue.offer(v);
						}
					}
				}
			}
		}
		
	}
}
