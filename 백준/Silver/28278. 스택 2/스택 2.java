import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Integer> st = new Stack<>(); 
	
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 명령
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int num = Integer.parseInt(st.nextToken());
			switch (num) {
			case 1:
				int x =Integer.parseInt(st.nextToken());
				add(x);
				break;
			case 2:
				print();
				break;
			case 3:
				size();
				break;
			case 4:
				empty();
				break;
			case 5:
				top();
				break;
			}
		}
	}
	
	public static void add(int x) {
		st.add(x);
	}
	
	public static void print() {
		if (!st.isEmpty()) {
			System.out.println(st.pop());
		} else {
			System.out.println(-1);
		}
	}
	
	public static void size() {
		System.out.println(st.size());
	}
	
	public static void empty() {
		if (st.isEmpty()) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	public static void top() {
		if (!st.isEmpty()) {
			System.out.println(st.peek());
		} else {
			System.out.println(-1);
		}
	}

}
