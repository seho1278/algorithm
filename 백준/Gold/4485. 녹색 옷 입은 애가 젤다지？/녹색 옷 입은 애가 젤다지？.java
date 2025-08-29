import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 녹색 옷을 입은 얘가 젤다 ?
 * 
 * N*N 크기의 지도에 0,0 위치에 젤다가 반대편 [N-1][N-1] 까지 이동해야함
 * 도둑루피 칸을 지나면 크기만큼 소지금 감소
 * 잃는 금액을 최소로 하여 동굴 건너편까지 이동, 한번에 상하좌우 인접 1칸씩 이동가능
 * 잃을 수 밖에 없는 최소 금액
 * 
 * N 크기는 2 <= N <= 125
 * 
 * 2차원 배열 델타탐색 -> 각 인접방향에 대한 최소 비용을 우선 탐색하여 이동해야함 (데이크스트라)
 */
public class Main {
	static int N;
	static int[][] matrix;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int problemCnt = 0;
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			
			if (N == 0) {
				break;
			}
			
			problemCnt++;
			
			matrix = new int[N][N];
			visited = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 해당 칸까지 최소 이동거리 기록
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited[i][j] = Integer.MAX_VALUE;
				}
			}
			
			bfs(0, 0);
			
			System.out.println("Problem " + problemCnt + ": " + visited[N-1][N-1]);
			
			
		} // while문 종료
		
	} // main
	
	public static void bfs(int row, int col) {
		// 해당 좌표의 검은 루피가 작은 값이 먼저 나오도록 comparator 설정
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		visited[row][col] = matrix[row][col];
		pq.offer(new int[] {row, col, visited[row][col]});
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			int cost = cur[2];
			
			if (visited[r][c] < cost) {
				continue;
			}
			
			// [N-1][N-1] 도착시 종료
			if (r == N-1 && c == N-1) {
				break;
			}
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if (nr < N && nr >= 0 && nc < N && nc >= 0) {
					// visit 갱신
					if (visited[nr][nc] > cost + matrix[nr][nc]) {
						visited[nr][nc] = cost + matrix[nr][nc];
						pq.add(new int[] {nr, nc, visited[nr][nc]});
					}
				}
			}
		}
		
	} // bfs
}
