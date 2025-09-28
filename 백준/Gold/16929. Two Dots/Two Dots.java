import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Union-Find 풀이
 * 
 * 서로소 집합을 이용
 * 각 비교하는 정점의 find 결과에 대한 root값이 동일한 경우
 * 같은 집합 즉 사이클이 발생하므로 그 즉시 탐색 종료하고 Yes 반환
 */

public class Main {
	
	// 자료구조 정적으로 관리
	static int N, M;
	static char[][] matrix;
	static int[] parent;

	// union-find 구현
	public static int find(int x) {
		if (parent[x] != x) {
			// 경로 압축 진행
			parent[x] = find(parent[x]);
		}
		
		return parent[x];
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			if (rootA < rootB) {
				parent[rootB] = rootA;
			} else {
				parent[rootA] = rootB; 
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix = new char[N][M];
		parent = new int[N * M];
		
		for (int i = 0; i < N * M; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = str.charAt(j);
			}
		}
		
		boolean isValid = false;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int u = i * M + j; // 시작 정점
				
				// right
				if (j + 1 < M && matrix[i][j] == matrix[i][j + 1]) {
					int v = i * M + (j + 1); // 방문 정점
					if (find(u) == find(v)) { // 같으면 사이클
						isValid = true;
						break;
					}
					union(u, v);
				}
				
				// down
				if (i + 1 < N && matrix[i][j] == matrix[i + 1][j]) {
					int v = (i + 1) * M + j; // 방문 정점
					if (find(u) == find(v)) { // 같으면 사이클
						isValid = true;
						break;
					}
					union(u, v);
				}
			}
			if (isValid) {
				break;
			}
		}
		
		System.out.println(isValid ? "Yes" : "No");
	}
	
}
