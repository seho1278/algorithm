import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if (num == 1) {
				continue;
			}
			
			int tmp = 1;
			for (int j = 1; j <= num / 2; j++) {
				if (num % j == 0) {
					tmp++;
				}
			}
			
			if (tmp == 2) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
