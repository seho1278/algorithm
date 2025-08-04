
/*
 * silver1_14888 연산자 끼워넣기
 */

import java.util.Scanner;

public class Main {
	static int N;
	static int[] numbers;
	static int[] operatorCnt = new int[4];
	
	// 최댓값과 최솟값
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	// 연산
	private static int calculate(int num1, int operatorIdx, int num2) {
		int result = 0;
		
		switch (operatorIdx) {
			case 0:
				result = num1 + num2;
				break;
			case 1:
				result = num1 - num2;
				break;
			case 2:
				result = num1 * num2;
				break;
			case 3:
				result = num1 / num2;
				break;
		}
		
		return result;
	}
	
	// 모든 경우의 수 탐색
	public static void dfs(int result, int depth) {
		if (depth == N - 1) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operatorCnt[i] > 0) {
				operatorCnt[i]--;
				
				int nextResult = calculate(result, i, numbers[depth + 1]);
				dfs(nextResult, depth + 1);
				
				operatorCnt[i]++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		numbers = new int[N];
		
		// 배열에 숫자 입력
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		
		// 연산자 입력
		for (int i = 0; i < 4; i++) {
			operatorCnt[i] = sc.nextInt();
		}
		
		dfs(numbers[0], 0);
		
		System.out.println(max);
		System.out.println(min);
		
	}
}
