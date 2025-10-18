import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {	
	static int N, M;
	static Map<Integer, Integer> map;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			map.put(f, t);
		}
		
		System.out.println(bfs());
	} // main
	
	public static int bfs() {
		int[] dist = new int[101];
		Arrays.fill(dist, -1);
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		dist[1] = 0;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			// 도착했을 때의 최소 결과값보다 현재 결과값이 큰 경우 무시
			if (cur == 100) {
				return dist[cur];
			}
			
			// 주사위를 1부터 6까지 굴리기
			for (int i = 1; i <= 6; i++) {
				int next = cur + i;
				
				if (next > 100) {
					continue;
				}
				
				// 사다리, 뱀이 있는 위치로 이동할경우 위치 갱신
				if (map.containsKey(next)) {
					next = map.get(next);
				}
				
				if (dist[next] == -1) {
					dist[next] = dist[cur] + 1;
					queue.offer(next);
				}
			}
			
		}
		return -1;
	}
}
