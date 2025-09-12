import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 미로탈출
 * 원하는 위치 시작 -> 원하는 위치까지의 최소 이동거리 구하기
 * 벽을 1회 부술 수 있음
 * 
 * 벽을 부수지 않은 경우와 부순 횟수를 3차원 배열 형태로 기록하면서 이동하기
 */

public class Main {
	static int[][] matrix;
	static int[][][] visited;
	static int N, M;
	static int[] start;
	static int[] end;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix = new int[N][M];
		visited = new int[N][M][2];
		
		// 입력값은 1-based -> 0-based에 맞게 1씩 감소된 값을 저장
		st = new StringTokenizer(br.readLine());
		start = new int[] {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
		st = new StringTokenizer(br.readLine());
		end = new int[] {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
		
		// 미로 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		System.out.println(bfs(start[0], start[1]));
	} // main
	
	public static int bfs(int row, int col) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		// 초기 위치 방문처리 (-1 - 다시 돌아오지 않기 위함)
		visited[row][col][0] = -1;
		visited[row][col][1] = -1;
		
		queue.offer(new int[] {row, col, 0, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			int m = cur[2];
			int b = cur[3];
			
			if (r == end[0] && c == end[1]) {
				return m;
			}
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (matrix[nr][nc] == 0) {
						if (visited[nr][nc][b] == 0) {
							visited[nr][nc][b] = m + 1;
							queue.offer(new int[] {nr, nc, m + 1, b});							
						}
					} else if (matrix[nr][nc] == 1) {
						if (b == 0 && visited[nr][nc][1] == 0) {
							visited[nr][nc][1] = m + 1;
							queue.offer(new int[] {nr, nc, m + 1, b + 1});								
						}
					}
				}
			}
		}
		
		return -1;
	} // bfs

}
