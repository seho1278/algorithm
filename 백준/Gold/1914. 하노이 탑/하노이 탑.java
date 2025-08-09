import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			// BigInteger를 사용한 이동횟수 출력
			System.out.println(new BigInteger("2").pow(n).subtract(BigInteger.ONE));
			if (n <= 20) {
				hanoi(n, 1, 3, 2);
			}
	}
	
	public static void hanoi(int n, int start, int end, int aux) {
			if (n == 1) {
					System.out.println(start + " " + end);
					return;
			}
			hanoi(n-1, start, aux, end);
			System.out.println(start + " " + end);
			hanoi(n-1, aux, end, start);
	}
}