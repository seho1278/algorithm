import java.util.Scanner;

// 각 문자열에 맞는 연산 수행
public class Main {
	static boolean[] set;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		set = new boolean[21];
		sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			String order = sc.next();
			int x = 0;
			if (!order.equals("all") && !order.equals("empty")) {
				x = sc.nextInt();
			}
			
			cmd(order, x);
		}
		
		System.out.println(sb.toString());
	}
	
	public static void cmd(String order, int x) {
		if (order.equals("add")) {
			set[x] = true;
		} else if (order.equals("remove")) {
			set[x] = false;
		} else if (order.equals("check")) {
			if (set[x]) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		} else if (order.equals("toggle")) {
			if (set[x]) {
				set[x] = false;
			} else {
				set[x] = true;
			}
		} else if (order.equals("all")) {
			for (int i = 1; i < set.length; i++) {
				if (!set[i]) {
					set[i] = true;
				}
			}
		} else if (order.equals("empty")) {
			set = new boolean[21];
		}
	}
}
