import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2775: 부녀회장이 될테야
        // 시간 복잡도: O(T * k * n)
        // ------------------------------------------------------------------------------------
        // * 0층의 i호에는 i명이 살고 k층의 n호에 살려면 (k-1)층의 1호부터 n호까지의 사람 수를 모두 더한 값이 필요
        // * 각 테스트 케이스에 대해 k와 n을 입력받고, DP 테이블을 이용해 k층 n호의 사람 수 출력
        // * DP 테이블은 2차원 배열로 선언하고 각 층과 호수에 대해 사람 수 채워나가기
        // ------------------------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            // k층과 n호 입력
            int k = sc.nextInt();
            int n = sc.nextInt();

            // 아파트 각 층과 호수의 거주민 수를 저장할 DP 테이블 생성
            int[][] dp = new int[k + 1][n + 1];

            // 0층 초기화: 0층의 i호에는 i명이 산다
            for (int i = 1; i <= n; i++) {
                dp[0][i] = i;
            }

            // 각 층의 거주민 수 계산
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }

            // 결과 출력
            System.out.println(dp[k][n]);
        }
    }
}