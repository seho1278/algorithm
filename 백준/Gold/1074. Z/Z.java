import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Z
 * 재귀와 분할정복 사용하여 풀이
 * N의 길이가 최대 15이기 때문에 2^15의 경우 32,768이기 때문에
 * 32,768 * 32,768을하게되면 10억이 넘어가므로 시뮬레이션을 돌리는 것은 시간초과가 발생한다.
 * 규칙을 찾아내는 것이 중요
 * 1. 목표지점이 2^N * 2^N 공간에서 네개의 사분면중 어디에 위치하는지 파악
 * 2. 목표지점이 속한 사분면에 도달할 때 까지 거쳐온 이전 사분면들의 넓이를 방문 횟수에 더해줌
 * 3. 목표 지점이 속한 사분면을 새로운 전체 공간으로 간주하고 좌표를 그 사분면의 시작점(0, 0) 기준으로 변환
 * 4. 이 과정을 공간의 크기가 1 * 1이 될때 까지 반복
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(solve(N, r, c));
	}
	
	public static int solve(int N, int r, int c) {
		if (N == 0) {
			return 0;
		}
		
		int half = 1 << (N - 1); // 2^(n-1)과 동일한 연산
		
		int quad = half * half;
		if (r < half && c < half) {
			return solve(N - 1, r, c);
		}
		
		else if (r < half & c >= half) {
			return quad + solve(N - 1, r, c - half);
		}
		
		else if (r >= half & c < half) {
			return quad * 2 + solve(N - 1, r - half, c);
		}
		
		else {
			return quad * 3 + solve(N - 1, r - half, c - half);
		}
	}
}
