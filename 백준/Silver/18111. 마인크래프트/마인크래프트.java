import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * 마인 크래프트
 * 땅고르기 작업
 * N * M 크기의 집터
 * 집터 맨 왼쪽 위의 좌표는 (0, 0)
 * 내 땅의 높이를 일정하게 바꾸는 것
 * 
 * 좌표 i, j의 가장 위의 블록을 제거해 인벤토리에 넣음
 * 인벤에서 블록을 꺼내 좌표 i, j의 가장 위에 있는 블록 위에 놓는다.
 * 1번 작업은 2초가 걸림 2번 작업은 1초 걸림
 * 땅 고르기 작업에 걸리는 최소시간과 땅의 높이 구하기
 * 땅의 높이는 256 초과 x -1 x
 * 
 * 입력 N, M, B(인벤토리 블록 개수)
 *
 */
public class Main {
	static int N, M;
	static int minTime = Integer.MAX_VALUE;
	static int maxHeight = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// i는 목표 타겟
		for (int i = 0; i <= 256; i++) {
			// 타겟으로 평탄화
			int curTime = work(matrix, i, B);
			
			// 최솟값 최댓값 비교
			
			if (minTime >= curTime) {
				minTime = curTime;
				maxHeight = Math.max(maxHeight, i);
			}			
		}
		
		System.out.println(minTime + " " + maxHeight);
	}
	
	public static int work(int[][] matrix, int target, int B) {
		int t = 0;

		// 타겟보다 높은 블록 먼저 제거
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// target과 같으면 넘김
				if (matrix[i][j] == target) {
					continue;
				}
				
				// 블록이 타겟보다 높이 있는 경우
				if (matrix[i][j] > target) {
					// 블록을 타겟만큼 파낸 시간을 추가
					t += (matrix[i][j] - target) * 2;
					// 인벤토리에 블록 저장
					B += matrix[i][j] - target;
					continue;
				}
			}
		}
		
		// 타겟보다 높지 않은 블록 쌓기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// target과 같으면 넘김
				if (matrix[i][j] == target) {
					continue;
				}
				
				// 블록이 타겟보다 높지 않은 경우
				if (matrix[i][j] < target) {
					// 쌓을 블록이 있는지 확인
					if (target - matrix[i][j] <= B) {
						// 있으면 쌓은 시간 추가
						t += target - matrix[i][j];
						B -= target - matrix[i][j];
						continue;
					} else {
						// 없으면 해당 target으로 평탄화는 불가능
						return Integer.MAX_VALUE;
					}
				}
			}
		}
		
		return t;
	}

}
