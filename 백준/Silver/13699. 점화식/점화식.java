import java.util.Scanner;

/**
 * 점화식
 * 타뷸레이션 방식 사용
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] dp = new long[n + 1];
		
		dp[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < i/2; j++) {
					dp[i] += (dp[j] * dp[i-1-j]) * 2;
				}
			} else {
				for (int j = 0; j < i/2; j++) {
					dp[i] += (dp[j] * dp[i-1-j]) * 2;
				}
				dp[i] += dp[i/2] * dp[i/2];
			}
		}

		System.out.println(dp[n]);
		
	}
}
