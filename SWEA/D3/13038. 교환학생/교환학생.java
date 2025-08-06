import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 교환학생
 * 
 * 일주일에 최소 한번 이상 수업 있음
 * simple - 1의 값을 찾아 시작 인덱스값으로 놓고 n번 진행하며 최솟값 찾기
 */

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		// System.setIn(new FileInputStream("sample_input.txt"));
		// 입력
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 수업
			int N = sc.nextInt();

			int[] week = new int[7];

			for (int i = 0; i < 7; i++) {
				week[i] = sc.nextInt();
			}

			int minDay = Integer.MAX_VALUE;

			for (int i = 0; i < 7; i++) {
                if (week[i] == 1) {
                    int lesson = 0;
                    int day = 0;
                    // lesson가 N값에 도달할 때까지 week 반복 순회
                    // week의 해당 day value 값이 1일때마다 lesson++
                    while (lesson < N) {
                        if (week[(i + day) % 7] == 1) {
                            lesson++;
                        }
                        day++;
                    }
                    // 최소 일수 확인
                    if (minDay > day) {
                        minDay = day;
                    }
                }
			}
			System.out.println("#" + tc + " " + minDay);
		}
	}

}
