import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 게리맨더링
 * 
 * 선거구를 두개로 나눠야 함
 * 선거구 구역은 적어도 하나를 포함 포함되어 있는 구역은 모두 연결되어야 함
 * 구역 A에서 인접한 구역을 통해 B구역을 갈 수 있을때 두 구역은 연결되어 있다고 함
 * 
 * 중간에 통하는 인접한 구역은 0개 이상 -> 모두 같은 선거구에 포함된 구역이여야 함
 * 
 * 두 선거구에 포함된 인구 차이 최솟값 구하기
 * 
 * 입력
 * 구역 개수 N
 * 1 ~ N 에 대한 인구
 * N개 줄에 대해 각 구역과 인접한 구역 정보가 주어짐
 * 
 * 6
 * 5 2 3 4 1 2 -> 1 ~ N에 대한 인구
 * 2 2 4 -> 1번 구역과 인접한 구역 수가 2 / 2, 4는 인접 구역
 * ...
 * 
 * 6개로 구성 가능한 A, B 조합 짜보기
 * A, B 조합이 완성되면
 * 선거구 조건 확인
 * 선거구 조건을 만족하면 두 선거구 인구차를 구하고 최솟값 갱신하기
 * 
 */
public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static Map<Integer, List<Integer>> graph;
	static int min = Integer.MAX_VALUE;
	static List<Integer> A;
	static List<Integer> B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		N = Integer.parseInt(br.readLine());
		
		
		// 인구수 저장
		arr = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int section = Integer.parseInt(st.nextToken());
				
				// 양방향 그래프 설정
				graph.get(i).add(section);
				graph.get(section).add(i);
			}
		}
		
		visited = new boolean[N + 1];
		
		dfs(1);
		
		System.out.println(min != Integer.MAX_VALUE ? min : -1);
		
	} // main
	
	public static void dfs(int depth) {
		if (depth == N + 1) {
			
			A = new ArrayList<>();
			B = new ArrayList<>();
			
			for (int i = 1; i <= N; i++) {
				if (visited[i]) {
					A.add(i);
				} else {
					B.add(i);
				}
			}
			
			if (A.size() == N || B.size() == N) {
				return;
			}
			
			// 선거구 유효성 검증
			if (possible(A) && possible(B)) {
				calculate();
			}
			
			return;
		}
		
		// A 선거구 포함된 경우와 아닌 경우를 재귀 호출
		visited[depth] = true;
		dfs(depth + 1);
		
		visited[depth] = false;
		dfs(depth + 1);
		
	}
	
	public static void calculate() {
		int sumA = 0;
		for (int i = 0; i < A.size(); i++) {
			sumA += arr[A.get(i)];
		}
		
		int sumB = 0;
		for (int i = 0; i < B.size(); i++) {
			sumB += arr[B.get(i)];
		}
		
		min = Math.min(min, Math.abs(sumA - sumB));
	}
	
	// 선거구 유효성 검중 (인접해야한다) - bfs 구현
	public static boolean possible(List<Integer> list) {
		if (list.size() <= 1) {
			return true;
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[N + 1];
		queue.offer(list.get(0));
		visit[list.get(0)] = true;
		int cnt = 1;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int num: graph.get(cur)) {
				// 방문하지 않았으면 방문체크후 queue 추가
				if (!visit[num] && list.contains(num)) {
					visit[num] = true;
					queue.offer(num);
					cnt++;
				}
			}
		}
		
		return cnt == list.size();
	} // possible
}
