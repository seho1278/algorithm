import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] people = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            people[i][1] = Integer.parseInt(st.nextToken()); // 키
        }

        StringBuilder sb = new StringBuilder();

        // 각 사람을 기준으로 반복 (i는 등수를 결정할 대상)
        for (int i = 0; i < N; i++) {
            int rank = 1; // 등수는 1부터 시작

            // 다른 모든 사람과 비교 (j는 비교 대상)
            for (int j = 0; j < N; j++) {
                // 자기 자신과는 비교할 필요가 없음
                if (i == j) continue;

                // 비교 대상(j)이 기준(i)보다 덩치가 큰 경우
                if (people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                    rank++; // 등수를 1 내린다 (숫자를 키운다)
                }
            }
            sb.append(rank).append(' ');
        }
        System.out.println(sb);
    }
}