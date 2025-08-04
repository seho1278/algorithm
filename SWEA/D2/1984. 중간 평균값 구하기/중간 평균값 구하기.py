import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

// 최대, 최소 수를 제외한 나머지 평균값을 출력 (소수점 첫째 자리에서 반올림한 정수 출력)

/*
 * 설계
 * 배열을 생성하여 입력 받은 후 정렬한 뒤 idx -> 1 부터 length-2까지 수를 더한 뒤 평균 구하기 
 */
class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int[] arr = new int[10];
		
		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			double avg = IntStream.range(1, arr.length - 1)
					.map(i -> arr[i]).average().orElse(0.0);
			int result = (int) Math.round(avg);
			
			System.out.println("#" + tc + " " + result);
		}
		
	}

}
