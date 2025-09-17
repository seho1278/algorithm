import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				
				if (s.equals("I")) {
					map.put(n, map.getOrDefault(n, 0) + 1);					
				} else {
					if (map.isEmpty()) continue;
					
					if (n == 1) {
						int maxKey = map.lastKey();
						int cnt = map.get(maxKey);
						if (cnt == 1) {
							map.remove(maxKey);
						} else {
							map.put(maxKey, cnt - 1);
						}
					} else {
						int minKey = map.firstKey();
						int cnt = map.get(minKey);
						if (cnt == 1) {
							map.remove(minKey);
						} else {
							map.put(minKey, cnt - 1);
						}
					}
				}
			}
			
			if (map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
			
		}
      System.out.println(sb.toString());
	}
}
