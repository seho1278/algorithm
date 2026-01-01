import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] arsg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		// dp 설계 현재 위치 숫자를 포함했을때 가장 긴 부분 수열 길이
		int[] a = new int[N];
		int[] dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		int maxLen = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		
		System.out.println(maxLen);
		
	}
}
