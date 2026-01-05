import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			boolean isValid = false;
			
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					if (i * j == N) {
						isValid = true;
						break;
					}
				}
				if (isValid) {
					break;
				}
			}
			
			System.out.println("#" + tc + " " + (isValid ? "Yes": "No"));
		}
	}
}