import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 9465: 스티커
        // ---------------------------------------------------------------
        // * DP 사용
        // * 2행 n열의 스티커 배열이 주어지고, 스티커를 하나 떼면
        //   그 스티커와 변을 공유하는 스티커는 사용할 수 없음
        // * 최대 점수를 얻기 위해서는 스티커를 선택하는 방법을 최적화해야 함
        // * dp[i][j]를 사용해 i번째 열에서 j번째 행을 선택했을 때 최대 점수 저장
        // * dp[i][0]은 첫 번째 행을 선택했을 때, dp[i][1]은 두 번째 행을 선택했을 때
        // ---------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수

        while (T-- > 0) {
            int n = sc.nextInt(); // 테스트 케이스의 n값

            // 스티커 배열 초기화
            int[][] sticker = new int[2][n];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = sc.nextInt();
                }
            }

            // dp 배열 초기화
            int[][] dp = new int[2][n];

            // 첫 번째 열의 초기값 설정
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];

            // n이 1이 아닌 경우 두 번째 열의 초기값 설정
            if (n > 1) {
                dp[0][1] = sticker[0][1] + dp[1][0];
                dp[1][1] = sticker[1][1] + dp[0][0];
            }

            // dp 점화식
            for (int i = 2; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }

            // 마지막 열의 최대값 비교
            int result = Math.max(dp[0][n - 1], dp[1][n - 1]);
            System.out.println(result);
        }

        sc.close();
    }
}