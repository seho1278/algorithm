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
 * 연구소
 */
public class Main {
	static int N, M;
	static int result;
	
	static List<int[]> arr;
	static int[][] lab;
	
	// 델타탐색 (상, 하, 좌, 우)
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기 안전구역 위치정보를 담을 ArrayList 생성
		arr = new ArrayList<>();
		
		// 벽과 바이러스는 방문처리하고 바이러스는 큐(좌표값으로)에 넣기, 안전구역은 arr에 좌표값으로 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 0) {
					arr.add(new int[] {i, j});
				}
			}
		}
		
		// 최댓값 저장
		result = Integer.MIN_VALUE;
		
		// 벽 치면서 바이러스 전염 시키고 최댓값 저장
		dfs(0, 0);
		
		// 안전구역 확인 후 출력
		System.out.println(result);
	}
	
	// 벽 3개씩 치면서 바이러스 오염되지 않은 안전구역 최댓값 찾기
	public static void dfs(int depth, int curIdx) {
		if (depth == 3) {			
			// 안전구역 체크
			result = Math.max(result, bfs(copy()));
			return;
		}
		
		if (curIdx == arr.size()) {
			return;
		}
			
		// 백트래킹
		// curIdx로 arr 좌표
		int[] cur = arr.get(curIdx);
		
		// 포함
		lab[cur[0]][cur[1]] = 1;
		dfs(depth + 1, curIdx + 1);		
			
		// 미포함
		lab[cur[0]][cur[1]] = 0;
		dfs(depth, curIdx + 1);
	}
	
	
	// 바이러스 전염
	public static int bfs(int[][] newLab) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newLab[i][j] == 1) {
					visited[i][j] = true;
				}
				
				if (newLab[i][j] == 2) {
					visited[i][j] = true;
					queue.add(new int[] {i, j});
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int row = cur[0];
			int col = cur[1];
			
			// 인접지역 탐색 후 
			for (int dir = 0; dir < 4; dir++) {
				int nr = row + dr[dir];
				int nc = col + dc[dir];
				
				// 오염되지 않은 지역
				if (nr < N && nr >= 0 && nc < M && nc >= 0 && !visited[nr][nc]) {
					// 안전구역 인지 확인
					if (newLab[nr][nc] == 0) {
						// 오염
						newLab[nr][nc] = 2;
						visited[nr][nc] = true;
						
						// nr, nc queue에 넣기
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}
		return checkSafety(newLab);
	}
	
	// 안전구역 확인
	public static int checkSafety(int[][] lab) {
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	public static int[][] copy() {
		int[][] copyLab = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyLab[i][j] = lab[i][j];
			}
		}
		
		return copyLab;
	}
}
