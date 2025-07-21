import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		// 정수형 입력 두개를 받아서 a, b 변수에 할당한다...!
//		long a = scanner.nextLong();
//		long b = scanner.nextLong();
		
		// a - b를 계산하여 출력해보세요...!
//		System.out.println(a + b);
		
		// long 값도 벗어나는 범위의 숫자면 어떻게할까?
		// -> 가변적인 크기를 가진 참조 자료형을 이용한다. (정수형 가변적인 참조자료형 BigInteger)
		// 변수에 데이터를 저장하는 것이 아닌 참조하는 형태
		BigInteger a = scanner.nextBigInteger();
		BigInteger b = scanner.nextBigInteger();
		
		System.out.println(a.add(b));
		
	}
}