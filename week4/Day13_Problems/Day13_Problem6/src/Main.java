import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2012: 등수 매기기
        // -----------------------------------------------------------
        // * 예상 등수와 실제 등수 간의 차이를 최소화해야 함
        // * 예상 등수를 정렬해 실제 등수를 할당하면 불만도 최소화 가능
        // * 그리디 알고리즘 사용
        // * 예상 등수를 오름차순으로 정렬하고 정렬된 예상 등수를 1등부터 N등까지 할당
        // -----------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 학생 수 입력받기
        int N = sc.nextInt();

        // 각 학생의 예상 등수를 저장할 배열
        int[] expectedRanks = new int[N];

        // 예상 등수를 배열에 저장
        for (int i = 0; i < N; i++) {
            expectedRanks[i] = sc.nextInt();
        }

        // 예상 등수를 오름차순으로 정렬
        Arrays.sort(expectedRanks);

        // 실제 등수를 1부터 N까지 할당하고 불만도의 합을 계산
        long sum = 0;
        for (int i = 0; i < N; i++) {
            // 예상 등수와 실제 등수의 차이를 절대값으로 구해 불만도 계산
            sum += Math.abs(expectedRanks[i] - (i + 1));
        }

        System.out.println(sum);
    }
}