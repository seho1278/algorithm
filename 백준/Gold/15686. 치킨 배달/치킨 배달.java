import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 치킨배달
 * 크기 N * N (도시는 1 * 1)
 * 도시 각 칸은 빈 칸, 치킨집, 집 중 하나 r, c 형태로 나타냄 위에서부터 r, 왼쪽에서부터 c칸 r, c는 1부터 시작
 * "치킨 거리"는 집과 가장 가까운 치킨집 사이의 거리
 * 집 기준으로 정해지며, 각각의 집은 치킨 거리를 가지고 있음 도시의 치킨 거리는 모든 집의 치킨 거리의 합
 * 도시에 있는 치킨집은 모두 같은 프렌차이즈
 * 가장 수익을 많이 낼 수 있는 치킨집의 개수는 최대 M개를 가정할 때
 * 도시의 치킨 거리가 가장 작게 될지 구하기
 * 
 * 도시 범위 N (2 <= N <= 50)
 * 치킨 집 개수 M (1 <= M <= 13)
 * 0은 빈칸 1은 집, 2는 치킨집 집의 개수 2N개를 넘지 않음 적어도 1개 존재
 */

public class Main {	
	static int min = Integer.MAX_VALUE;
	static List<int[]> list1 = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static boolean[][] visited;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				matrix[i][j] = tmp;
				
				// 집과 치킨집의 정보를 저장
				if (tmp == 1) {
					list1.add(new int[] {i, j, 0});
				} else if (tmp == 2) {
					list2.add(new int[] {i, j});
				}
				
			}
		}
		
		visited = new boolean[N + 1][N + 1];
		
		dfs(0, 0);
		
		System.out.println(min);
	}
	
	public static void dfs(int depth, int idx) {
		if (depth == M) {
			bfs();
			return;
		}
		
		if (idx >= list2.size()) {
			return;
		}
		
		int[] cur = list2.get(idx);
		visited[cur[0]][cur[1]] = true;
		dfs(depth + 1, idx + 1);
		visited[cur[0]][cur[1]] = false;
		dfs(depth, idx + 1);
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		
		// 시작 전 각 집의 치킨거리 0으로 초기화
		for (int i = 0; i < list1.size(); i++) {
			list1.get(i)[2] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < list2.size(); i++) {
			int[] tmp = list2.get(i);
			// true면 queue에 넣기
			if (visited[tmp[0]][tmp[1]]) {
				queue.add(tmp);
			}
		}
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int row = cur[0];
			int col = cur[1];
			
			// 해당 치킨집에서 집까지의 거리 저장
			for (int i = 0; i < list1.size(); i++) {
				int[] house = list1.get(i);
				int hRow = house[0];
				int hCol = house[1];
				
				// 각 치킨집에서 최단 거리 저장
				house[2] = Math.min(house[2], Math.abs(hRow - row) + Math.abs(hCol - col));
			}
		}
		
		// 치킨 거리 최솟값 갱신
		min = Math.min(min, sum());
	}
	
	public static int sum() {
		int sum = 0;
		
		for (int i = 0; i < list1.size(); i++) {
			sum += list1.get(i)[2];
		}
		
		return sum;
	}
}
