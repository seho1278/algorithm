import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 청소 영역 개수 구하기
 * 
 * 1. 현재칸 청소 2. 현재 칸의 인접 4칸 중 청소되지 않은 빈 칸이 없는 경우 - 바라보는 방향 유지 -> 한칸 후진 가능하면 후진 후
 * 1번으로 - 뒤쪽 칸이 벽이라 후진이 안되면 작동 중지 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는 경우 - 반시계 방향으로
 * 90도 회전 - 바라보는 방향 기준 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진 - 1번으로
 * 
 * 입력 N, M (3 <= N, M <= 50) r, c, d (0 북 1 동 2 남 3서) 이차원 배열 (0은 청소 x, 1은 벽)
 * 
 * BFS 구현 청소 -> 2로 표시
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 0: 북 1:동 2:남 3:서
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[][] matrix = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;

		// 로봇 청소기 로직
		while (true) {
			int nr;
			int nc;
			// 현재칸 청소
			if (matrix[r][c] == 0) {
				matrix[r][c] = 2;
				result++;
			}

			// 청소구역 확인
			boolean isValid = false;

			// 4방향 탐색으로 청소해야될 구역이 있는지 확인
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];

				// 청소할 수 있는 구역이 있는 경우
				if (matrix[nr][nc] == 0) {
					isValid = true;
				}
			}

			// 청소 구역이 없는 경우
			if (!isValid) {
				// 후진이 가능한지 확인
				nr = r + dr[(d + 2) % 4];
				nc = c + dc[(d + 2) % 4];

				
				// 벽이 아니어야 함
				if (!(matrix[nr][nc] == 1)) {
					//  후진 후 처음으로 이동
					r = nr;
					c = nc;
					continue;
				}
				
				// 벽인 경우 작동 중지
				else {
					break;
				}
			}
			
			// 청소 구역이 있는 경우
			else {
				// 반시계 방향 회전
				d = (d + 3) % 4;
				
				nr = r + dr[d];
				nc = c + dc[d];
				
				// 바라보는 방향 기준 앞쪽 칸이 청소되지 않았으면 한칸 전진
				if (matrix[nr][nc] == 0) {
					r = nr;
					c = nc;
				}
			}
		}

		System.out.println(result);

	}
}
