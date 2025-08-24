import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * baam
 * 사과를 먹으면 뱀 길이가 길어짐
 * 벽 or 자기 자신의 몸과 부딪히면 게임 끝
 * N * N 정사각 보드 위에서 진행, 몇몇 칸에는 사과가 놓임 보드의 상하좌우 끝에 벽
 * 뱀은 맨위 맨좌측에 위치 뱀의 길이는 1 처음에 오른쪽 끝을 향함
 * 
 * 매 초 이동
 * 
 * 규칙
 * 몸길이를 늘려 머리를 다음 칸에 위치
 * 벽이나 자기 자신과 부딪히면 게임 끝
 * 이동한 칸에 사과 있으면 해당 칸에 있던 사과는 없어지고 꼬리는 움직이지 않음
 * 이동한 칸에 사과가 없다면 몸길이를 줄여 꼬리가 위치한 칸을 비워줌, 몸길이는 변하지 않음
 * 게임이 몇초에 끝나는지 계산
 * 
 * 보드 크기 N
 * K줄에 사과 위치 r, c
 * 뱀의 방향 변환 횟수 L
 * L개 줄에는 뱀의 방향 변환 정보
 * 정수 X 문자 C
 * X초가 끈난 뒤 왼쪽 또는 오른쪽으로 90 회전 (C가 'L') 오른쪽(C가 'D')
 */

public class Main {
	static int N, K, L;
	// 뱀
	static ArrayDeque<int[]> deque;
	// 사과 위치 정보
	static List<int[]> apple;
	// 방향 정보
	static Map<Integer, String> dir;
	// 진행 시간
	static int t;
	
	// 이동
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		deque = new ArrayDeque<>();
		apple = new ArrayList<>();
		dir = new HashMap<>();
		
		// 뱀 초기 위치 저장
		deque.addFirst(new int[] {1, 1});
		
		// 사과 위치 저장
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			apple.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		L = Integer.parseInt(br.readLine());
		
		// 방향 전환 정보 입력
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dir.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		t = 0;
		
		// 시작 방향은 오른쪽
		int d = 3;
		
		while (true) {
			t++;
			// 뱀 머리의 현재 위치
			int[] cur = deque.peekFirst();
			
			// 다음 지점
			int nr = cur[0] + dr[d];
			int nc = cur[1] + dc[d];
			
			int[] next = new int[] {nr, nc};
			
			// 다음 지점이 벽에 나가거나 뱀이랑 부딪히는지 확인
			if (nr > N || nr <= 0 || nc > N || nc <= 0 || snakeContains(next)) {
				// 게임 시간 출력 후 종료
				System.out.println(t);
				break;
			}
			
			// 없으면 이동
			deque.addFirst(next);
			
			// 이동 위치에 사과가 없으면 뱀의 길이 유지
			if (!appleContains(next)) {
				deque.pollLast();
			}
			
			// dir key값에 t 정보가 있다면 방향 전환
			if (dir.containsKey(t)) {
				// 이동 방향 변경
				d = turn(d, dir.get(t));
			}
		}
	}
	
	public static int turn(int d, String dir) {
		// L이면 왼쪽 회전
		if (dir.equals("L")) {
			// 진행방향이 오른쪽인 경우 위로 변경
			if (d == 3) { return 0; }
			// 왼쪽인 경우 아래로 변경
			if (d == 2) { return 1; }
			// 위쪽인 경우 왼쪽으로 변경
			if (d == 0) { return 2; }
			// 아래쪽인 경우 오른쪽으로 변경
			if (d == 1) { return 3; }
		}
		
		// R이면 오른족 회전
		else if (dir.equals("D")) {
			// 진행방향이 오른쪽인 경우 아래로 변경
			if (d == 3) { return 1; }
			// 왼쪽인 경우 위로 변경
			if (d == 2) { return 0; }
			// 위쪽인 경우 오른쪽으로 변경
			if (d == 0) { return 3; }
			// 아래쪽인 경우 왼쪽으로 변경
			if (d == 1) { return 2; }
		}
		
		return -1;
	}
	
	public static boolean snakeContains(int[] arr1) {
		for (int[] arr: deque) {
			if (arr[0] == arr1[0] && arr[1] == arr1[1]) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean appleContains(int[] arr1) {
		for (int i = 0; i < apple.size(); i++) {
			int[] arr = apple.get(i);
			if (arr[0] == arr1[0] && arr[1] == arr1[1]) {
				apple.remove(i);
				return true;
			}
		}
		
		return false;
	}
}
