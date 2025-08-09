import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void hanoi(int n, int start, int end, int aux) {
        if (n == 1) {
        	sb.append(start + " " + end + "\n");
            return;
        }
        
        hanoi(n-1, start, aux, end);
        sb.append(start + " " + end + "\n");
        hanoi(n-1, aux, end, start);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(((int) Math.pow(2, n)) - 1);
        hanoi(n, 1, 3, 2);
        System.out.println(sb.toString());
    }
}