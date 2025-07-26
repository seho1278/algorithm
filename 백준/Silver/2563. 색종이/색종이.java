import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int colorPaper = Integer.parseInt(br.readLine());
		
		int[][] matrix = new int[100][100];
		
		int sum = 0;
		
		for (int i = 0; i < colorPaper; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for (int j = r; j < r + 10; j++) {
				for (int k = c; k < c + 10; k++) {
					matrix[j][k]++;
					if (matrix[j][k] == 1) {
						sum++;
					}
				}
			}
		}
		
		System.out.println(sum);
	}
}