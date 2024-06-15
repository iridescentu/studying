// 백준 9095: 1, 2, 3 더하기
// 시간 복잡도: O(N)
// ----------------------------------------------------
// * 정수 n을 1, 2, 3의 합으로 나타내는 방법의 수를 구해야 함
// * n이 11보다 작기 때문에, 최대 n=10까지의 값을 미리 계산해두고,
//   각 테스트 케이스에서 미리 계산된 값을 반환
// * 점화식: dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
// * 초기값: dp[1] = 1, dp[2] = 2, dp[3] = 4
// ----------------------------------------------------

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스의 개수 입력
        int N = sc.nextInt();

        // 각 테스트 케이스의 값을 저장할 배열
        int[] testCases = new int[N];
        for (int i = 0; i < N; i++) {
            testCases[i] = sc.nextInt();
        }

        // n이 11보다 작기 때문에 최대 n=10까지의 값을 미리 계산
        int[] dp = new int[11];

        // 초기값 설정
        dp[1] = 1; // 1을 1의 합으로 나타내는 방법은 1가지
        dp[2] = 2; // 2를 1+1, 2의 합으로 나타내는 방법은 2가지
        dp[3] = 4; // 3을 1+1+1, 1+2, 2+1, 3의 합으로 나타내는 방법은 4가지

        // 점화식을 이용하여 dp 배열 채우기
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; // dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
        }

        // 각 테스트 케이스에 대해 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.println(dp[testCases[i]]);
        }

        sc.close();
    }
}