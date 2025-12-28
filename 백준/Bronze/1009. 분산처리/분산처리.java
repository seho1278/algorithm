import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println(calculateLastDigit(a, b));
		}
	}
	
	public static int calculateLastDigit(int a, int b) {		
		// 마지막 자리수만 추출
		int base = a % 10;
		// 분할정복
		int result = power(base, b, 10);
		
		// 엣지 케이스 처리
		return (result == 0) ? 10 : result;
	}
	
	private static int power(int base, int exp, int mod) {
		if (base == 0) return 0; // 밑이 10의 배수인 경우 처리
		
		int res = 1;
		base %= mod;
		
		while (exp > 0) {
			// 지수가 홀수면 결과의 현재 base를 곱하기
			if (exp % 2 == 1) {
				res = (res * base) % mod;
			}
			
			// 지수를 절반으로 줄이고 base를 제곱
			base = (base * base) % mod;
			exp /= 2;
		}
		return res;
	}
}
