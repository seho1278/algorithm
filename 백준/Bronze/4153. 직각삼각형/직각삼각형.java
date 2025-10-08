import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if (a == 0 && b == 0 && c == 0) {
				break;
			}
			
			boolean isValid = false;
			
			if (a > b && a > c) {
				isValid = Math.pow(a, 2) == Math.pow(c, 2) + Math.pow(b, 2);
			} else if (b > a && b > c) {
				isValid = Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2);
			} else if (c > a && c > b) {
				isValid = Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2);
			} else {
				isValid = false;
			}
			
			
			System.out.println(isValid ? "right" : "wrong");
		}
	}
}