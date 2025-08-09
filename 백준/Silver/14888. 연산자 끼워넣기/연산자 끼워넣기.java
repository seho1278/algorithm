import java.util.Arrays;
import java.util.Scanner;

/* 연산자 끼워넣기
 * 문제 관련 내용은 기록 참고
 */

public class Main {
	// 배열들은 전역 변수로 관리
	static int[] numbers;
	static char[] operators;
	static boolean[] visited;
	static int[] result = new int[2];
	static {
		result[0] = Integer.MIN_VALUE;
		result[1] = Integer.MAX_VALUE;
	}
	
	// 계산기 (계산할 현재 값 current와 다음 숫자 next, 연산자를 파라미터 값으로 전달)
	public static int calculator(int current, int next, char operator) {
		// 연산자에 따라 계산 수행
		switch (operator) { 
			case '+':
				return current + next;
			case '-':
				return current - next;
			case '*':
				return current * next;
			case '/':
				return current / next;
		}
		return -1; // 형식상 작성
	}
	
	// dfs(순회 후 구한 최댓값과 최솟값을 배열에 저장해 반환)
	// 현재 값과 깊이 depth, 최댓값과 최솟값을 저장할 배열를 파라미터 값으로 전달
	public static void dfs(int current, int depth) {
		// BaseCase
		// depth가 numbers.length가 될경우 모든 수를 사용했으므로 최종 연산 결과를 반환한다.
		if (depth == numbers.length) {
			result[0] = Math.max(result[0], current);
			result[1] = Math.min(result[1], current);
			return;
		}
		
		// Recursive step
		// 첫번째로 사용할 연산자 선택
		for (int i = 0; i < operators.length; i++) {
			// 해당 연산자가 사용중인지 확인
			if (!visited[i]) {
				// 해당 연산자 방문 처리
				visited[i] = true;
				
				// 현재 값과 다음 값을 넣어 계산한 결과를 저장
				int operate = calculator(current, numbers[depth], operators[i]);
				
				// 계산된 값과 depth를 1증가시켜 새로운 dfs 호출
				dfs(operate, depth + 1);				
				
				// 사용한 연산자를 다시 원래 상태로 복구
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// N개 수를 저장할 배열 numbers 생성
		numbers = new int[N];
		
		// N개 배열에 피연산자 입력
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		
		// 연산자를 저장할 배열 operators 생성
		operators = new char[N-1];
		// 연산자 수에 맞게 방문처리를 도와줄 배열 visited 생성
		visited = new boolean[N-1];
		
		// 연산자를 풀어서 저장하기 위해 임시로 사용
		char[] tmp = {'+', '-', '*', '/'};
		int tmpIdx = 0; 
		
		// 주어지는 연산자들을 풀어서 저장
		for (int i = 0; i < 4; i++) {
			// 해당 연산자 개수만큼 반복하며 저장
			int t = sc.nextInt();
			for (int j = 0; j < t; j++) {
				operators[tmpIdx++] = tmp[i];
			}
		}
		
		// 순열을 돌릴 dfs 현재 값과 depth를 1로 설정하여 전달
		dfs(numbers[0], 1);
		
		// 최댓값과 최솟값 출력
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
