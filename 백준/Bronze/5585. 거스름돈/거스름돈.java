import java.util.Scanner;

public class Main {
	static int[] coins = new int[] {500, 100, 50, 10, 5, 1};
	static int money = 1000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int change = money - sc.nextInt();
		int cnt = 0;
		
		for (int coin : coins) {
			cnt += change / coin;
			change %= coin;
		}
	
		System.out.println(cnt);
	}

}
