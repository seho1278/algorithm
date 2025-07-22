import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int min = sc.nextInt();
		
		int t = sc.nextInt();
		
		hour = (hour + ((min + t) / 60)) % 24;
		min = (min + t) % 60;
		
		System.out.println(hour + " " + min);
				
	}

}
