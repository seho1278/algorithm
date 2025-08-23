import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 평범한 배낭
 * 
 * 배낭을 최대한 가치 있게
 * N개의 물건
 * 무기 w와 가치v
 * 물건을 v만큼 즐길 수 있음
 * 최대 K만큼 무게 넣을 수 있는 배낭으로
 * 최대한 즐거운 여행하기 위해 넣을 수 있는 물건들의 가치 최댓값 구하기
 * 
 * 물품 수 N (1 <= N <= 100), 버틸 수 있는 무게 K (1 <= K <= 100,000)
 * 물건의 무게 W K (1 <= W <= 100,000), 해당 물건의 가치 W K (0 <= V <= 1,000)
 * 
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		// 배낭에 넣을 수 있는 물건의 최대 무게
		int K = Integer.parseInt(st.nextToken());
		
		// 낮은 무게부터 갱신
		int[][] items = new int[N + 1][2];
		
		
		// 각 무게에 대한 최대 행복도를 저장할 dp테이블 생성
		int[] dp = new int[K + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken()); // 무게 W
			items[i][1] = Integer.parseInt(st.nextToken()); // 가치 V
		}
			
			
		for (int i = 1; i <= N; i++) {
			int w = items[i][0];
			int v = items[i][1];
			
			for (int j = K; j >= w; j--) {
				dp[j] = Math.max(dp[j], dp[j - w] + v);
			}
		}
		
		System.out.println(dp[K]);
	}
}
