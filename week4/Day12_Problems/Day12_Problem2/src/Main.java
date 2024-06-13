// 백준 25176: 청정수열
// 시간 복잡도: O(N)
// ------------------------------------------------------------------------------
// * 정수 N이 주어졌을 때 길이가 2N인 청정수열의 점수가 최소가 되는 경우의 수를 구해야 함
// * 청정수열: 1부터 N까지의 정수들이 정확히 두 번씩 등장하는 수열
// * 이를 최소화하는 수열을 찾아야 함
// * 점수를 최소화하려면 각 숫자가 가능한 한 가까운 위치에 있어야 함
// * N이 1일 때는 유일한 청정수열이 하나 존재함
// * N이 2 이상일 때는 최소 점수 청정수열의 개수는 N!로 계산됨
//   이는 각 숫자가 가까운 위치에 있는 모든 순열의 수임
// -------------------------------------------------------------------------------

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(countMinScoreSequences(N));
    }

    // 청정수열의 개수를 세는 함수
    public static int countMinScoreSequences(int N) {
        // N이 1일 때는 유일한 청정수열이 하나 존재
        if (N == 1) {
            return 1;
        }
        // N이 2 이상일 때, 모든 최소 점수 청정수열의 개수는 N!
        return factorial(N);
    }

    // 팩토리얼을 계산하는 함수
    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}