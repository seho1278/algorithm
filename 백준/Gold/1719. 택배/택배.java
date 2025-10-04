import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 택배
 * 집하장에서 다른 집하장으로 최단경로로 화물을 이동시키기 위해 가장 먼저 거처야 하는 집하장이 있음
 * 4행 5열에 6이 있다면 4번에서 5번으로 최단 경로로 가기 위해서는 제일 먼저 6번 집하장으로 이동해야함
 * 
 * 모든 정점에서 모든 정점으로 이동하는 경우 플로이드 워셜 사용
 */
public class Main {
	static int V, E;
	static final int INF = 987654321;
	static int[][] matrix;
	static int[][] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		matrix = new int[V + 1][V + 1];
		result = new int[V + 1][V + 1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			matrix[u][v] = w;
			matrix[v][u] = w;
			result[u][v] = v;
			result[v][u] = u;
		}
		
		floyd();
		
		// StringBuilder를 사용하면 시간을 더 줄일 수 있음
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j) {
					System.out.print("-" + " ");
				} else {
					System.out.print(result[i][j] + " ");					
				}
			}
			System.out.println();
		}
	}
	
	public static void floyd() {
		int[][] dp = new int[V + 1][V + 1];
		
		// dp 배열 초기화
		for (int i = 1; i <= V; i++) {
			Arrays.fill(dp[i], INF);
		}
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j) {
					dp[i][j] = 0;
				} else if (matrix[i][j] != 0) {
					dp[i][j] = matrix[i][j];
				}
			}
		}
		
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (dp[i][j] > dp[i][k] + dp[k][j]) {
						dp[i][j] = dp[i][k] + dp[k][j];
						result[i][j] = result[i][k];						
					}
				}
			}
		}
	}
}
