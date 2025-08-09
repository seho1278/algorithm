import java.math.BigInteger;
import java.util.Scanner;

/**
 * 하노이의 탑
 * 
 * 대표적인 재귀 구현 문제
 * 
 * 1 2 3 의 장대가 있을때
 * 1에 있는 모든 원판을 3의 원판으로 옮기기
 * 
 * 1.
 * 1에 있는 N 크기의 원판을 3으로 옮기기 위해선 N-1개의 원판을 2로 옮겨야함
 * 2로 N-1개를 옮길 때 3을 보조바로 사용
 * 
 * 2.
 * N -> 3이동
 * 
 * 3.
 * 1 선반을 보조바로 이용해 N-1개 원판을 3으로 옮기기
 * 재귀를 어떤 형태로 구현해야하나??
 */
public class Main {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
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
