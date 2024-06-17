import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1149: RGB 거리
        // ---------------------------------------------
        // * 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때,
        //   모든 집을 칠하는 비용의 최소값을 구해야 함
        // * dp[i][j] = i번째 집을 j색으로 칠하는 최소 비용
        //    - j: 0(빨강), 1(초록), 2(파랑)
        // ---------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 집의 수 입력
        int N = sc.nextInt();

        // 비용 배열 초기화
        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            // 각 집을 빨강, 초록, 파랑으로 칠하는 비용 입력
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        // DP 배열 초기화
        int[][] dp = new int[N][3];

        // 첫 번째 집의 비용은 주어진 값으로 초기화
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        // 각 집을 칠하는 최소 비용 계산
        for (int i = 1; i < N; i++) {
            // i번째 집을 빨강으로 칠하는 비용
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            // i번째 집을 초록으로 칠하는 비용
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            // i번째 집을 파랑으로 칠하는 비용
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }

        // 마지막 집까지 계산한 후, 세 가지 색 중 최소값 출력
        int result = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.println(result);
    }
}