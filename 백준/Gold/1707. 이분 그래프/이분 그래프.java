import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] graph;
	static int[] groups;
	static boolean isValid;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < K; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[V + 1];
			groups = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				graph[v].add(u);
			}
			
			isValid = true;
			
			for (int i = 1; i <= V; i++) {
				if (groups[i] == 0) {
					if (!dfs(i, 1)) {
						isValid = false;
						break;
					}
				}
			}
			sb.append(isValid ? "YES\n" : "NO\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean dfs(int u, int group) {
		groups[u] = group;
		
		for (int v : graph[u]) {
			if (groups[v] == 0) {
				if (!dfs(v, -group)) {
					return false;
				}
			} else if (groups[v] == groups[u]) {
				return false;
			}
		}
		return true;
	}
}
