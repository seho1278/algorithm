import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			
			for (int i = 2; i < N - 2; i++) {
				int max = 0;
				boolean isValid = true;
				for (int j = -2; j <= 2; j++) {
					if (i == i + j) continue;
					
					if (arr[i] > arr[i + j]) {
						max = Math.max(max, arr[i + j]);
					} else {
						isValid = false;
						break;
					}
				}
				
				if (isValid) sum += arr[i] - max;
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}
}
