import java.util.Scanner;

/**
 * N-Queen 최적화
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(dfs(N, 0, new boolean[N], new boolean[N * 2 - 1], new boolean[N * 2 + 1]));
	}
	
	public static int dfs(int N, int row, boolean[] cols, boolean[] diag1, boolean[] diag2) {
		if (row == N) {
			return 1;
		}
		
		int count = 0;
		
		for (int col = 0; col < N; col++) {
			if (!cols[col] && !diag1[row + col] && !diag2[row - col + N - 1]) {
				cols[col] = true;
				diag1[row + col] = true;
				diag2[row - col + N - 1] = true;
				
				count += dfs(N, row + 1, cols, diag1, diag2);
				
				cols[col] = false;
				diag1[row + col] = false;
				diag2[row - col + N - 1] = false;
			}
		}
		
		return count;
	}
	
	
	
	
}
