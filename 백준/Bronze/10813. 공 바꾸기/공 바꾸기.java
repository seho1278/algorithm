import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		for (int i = 0; i < M; i++) {
			int x1 = sc.nextInt();
			int x2 = sc.nextInt();
			
			int tmp = arr[x1 - 1];
			arr[x1 - 1] = arr[x2 - 1];
			arr[x2 - 1] = tmp;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
}