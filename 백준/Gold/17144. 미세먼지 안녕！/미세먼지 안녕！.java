import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, T;
	static int[][] matrix;
	static int airCleanerTop, airCleanerBottom;	
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		matrix = new int[R][C];
		boolean isCleanerFound = false;
		
		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if (matrix[i][j] == -1 && !isCleanerFound) {
					airCleanerTop = i;
					airCleanerBottom = i + 1;
					isCleanerFound = true;
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			spread();			
			cleanerOn();
		}
		
		// 미세먼지 총량 계산
		int total = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (matrix[i][j] > 0) {
					total += matrix[i][j];
				}
			}
		}
		
		System.out.println(total);
	} // main
	
	// 미세먼지 확산
	public static void spread() {
		// 확산 결과를 저장할 임시 2차원 배열 생성
		int[][] tmp = new int[R][C];
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (matrix[r][c] == -1) {
					tmp[r][c] = -1;
					continue;
				}
				
				// 현재 위치에 남는 먼지 양을 임시 배열에 더함
				int remainingDust = matrix[r][c];
				int spreadAmount = matrix[r][c] / 5;
				
				// 4방향 확산
				for (int dir = 0; dir < 4; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					
					// 범위를 벗어나거나 공기청정기가 있는 곳으로는 확산되지 않음
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || matrix[nr][nc] == -1) {
                        continue;
                    }
                    
                    tmp[nr][nc] += spreadAmount;
                    remainingDust -= spreadAmount;
				}
				tmp[r][c] += remainingDust;
			}
		}
		
		matrix = tmp;
	}
	
	// 공기청정기 작동
	public static void cleanerOn() {
        int top = airCleanerTop;

        // 1. 아래 -> 위 (왼쪽 열)
        for (int r = top - 1; r > 0; r--) matrix[r][0] = matrix[r - 1][0];
        // 2. 오른쪽 -> 왼쪽 (맨 위 행)
        for (int c = 0; c < C - 1; c++) matrix[0][c] = matrix[0][c + 1];
        // 3. 위 -> 아래 (오른쪽 열)
        for (int r = 0; r < top; r++) matrix[r][C - 1] = matrix[r + 1][C - 1];
        // 4. 왼쪽 -> 오른쪽 (공기청정기 행)
        for (int c = C - 1; c > 1; c--) matrix[top][c] = matrix[top][c - 1];
        
        // 공기청정기에서 나온 바람은 먼지가 없음
        matrix[top][1] = 0;

        int bottom = airCleanerBottom;

        // 1. 위 -> 아래 (왼쪽 열)
        for (int r = bottom + 1; r < R - 1; r++) matrix[r][0] = matrix[r + 1][0];
        // 2. 오른쪽 -> 왼쪽 (맨 아래 행)
        for (int c = 0; c < C - 1; c++) matrix[R - 1][c] = matrix[R - 1][c + 1];
        // 3. 아래 -> 위 (오른쪽 열)
        for (int r = R - 1; r > bottom; r--) matrix[r][C - 1] = matrix[r - 1][C - 1];
        // 4. 왼쪽 -> 오른쪽 (공기청정기 행)
        for (int c = C - 1; c > 1; c--) matrix[bottom][c] = matrix[bottom][c - 1];
        
        // 공기청정기에서 나온 바람은 먼지가 없음
        matrix[bottom][1] = 0;
    }
}
