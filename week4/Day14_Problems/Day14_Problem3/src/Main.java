import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 11722: 가장 긴 감소하는 부분 수열
        // 시간 복잡도: O(N^2)
        // ----------------------------------------------------------------------------
        // * 수열 A가 주어졌을 때 각 원소를 마지막 원소로 하는
        //   가장 긴 감소하는 부분 수열의 길이를 저장할 DP 배열 생성
        // * DP 배열의 각 원소 dp[i]는 A[i]를 마지막 원소로 하는 가장 긴 감소하는 부분 수열의 길이를 의미
        // ----------------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 수열 A의 크기 N 입력
        int N = sc.nextInt();
        int[] A = new int[N];

        // 수열 A의 원소들 입력
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // DP 배열 생성
        int[] dp = new int[N];

        // 각 원소는 자기 자신만 포함하는 부분 수열이기 때문에 초기값을 1로 설정
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        // DP 테이블 채우기
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // 만약 A[j]가 A[i]보다 크다면 감소하는 부분 수열을 만들 수 있으니 dp[i]를 갱신
                if (A[j] > A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // DP 배열에서 최대값을 찾아 가장 긴 감소하는 부분 수열의 길이를 출력
        int maxLength = 0;
        for (int i = 0; i < N; i++) {  // 수정: 인덱스 0부터 시작해야 함
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(maxLength);
    }
}