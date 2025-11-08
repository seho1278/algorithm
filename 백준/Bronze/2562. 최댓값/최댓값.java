import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int num = sc.nextInt();
			max = Math.max(num, max);
			arr[i] = num;
		}
		
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == max) {
				idx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(idx + 1);
		
	}

}
