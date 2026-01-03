import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int Z = sc.nextInt();

			// 큰 수로 정렬
			List<Integer> li = new ArrayList<>();
			
			li.add(X);
			li.add(Y);
			li.add(Z);
			
			Collections.sort(li);
						
			if (!li.get(1).equals(li.get(2))) {
                System.out.println("-1 -1 -1");
            } else {
                int A = Math.min(X, Z);
                int B = Math.min(X, Y);
                int C = Math.min(Y, Z);
                
                System.out.println(A + " " + B + " " + C);
            }
		}
		
	}
}
