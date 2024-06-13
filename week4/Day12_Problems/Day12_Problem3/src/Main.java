// * 백준 30821: 별자리가 될 수 있다면
// * 시간 복잡도: O(n)
// -------------------------------------------------------------------------
// * 주어진 N각형의 꼭짓점을 이어서 만들 수 있는 별의 개수를 구해야 함
// * N각형에서 꼭짓점을 서로 다른 방식으로 이어서 별을 만들 수 있는 경우의 수를 구해야 함
// * 이를 위해, 별을 만드는 방법을 조합으로 생각할 수 있음
// * N개의 꼭짓점 중 5개를 선택하여 별을 만드는 경우의 수를 구함
// * 조합의 수는 'N choose 5'로 계산됨
// * 조합의 수 공식: C(N, k) = N! / (k! * (N - k)!) 여기서 k는 5
// * N이 100까지 주어질 수 있기 때문에 큰 수의 팩토리얼을 계산할 수 있는 방법이 필요함
// -------------------------------------------------------------------------

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    // 팩토리얼을 계산하는 함수
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // 조합의 수를 계산하는 함수
    public static BigInteger combination(int n, int k) {
        BigInteger numerator = factorial(n); // 분자: n!
        BigInteger denominator = factorial(k).multiply(factorial(n - k)); // 분모: k! * (n-k)!
        return numerator.divide(denominator); // 조합 계산: n! / (k! * (n-k)!)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 입력값 N을 받음
        sc.close();

        if (N < 5) {
            System.out.println(0); // N이 5보다 작은 경우, 별을 만들 수 없음
        } else {
            BigInteger result = combination(N, 5); // N각형에서 5개의 꼭짓점을 선택하는 조합의 수를 계산
            System.out.println(result); // 결과 출력
        }
    }
}