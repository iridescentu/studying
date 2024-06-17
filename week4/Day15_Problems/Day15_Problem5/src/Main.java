import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 11047: 동전 0
        // ------------------------------------------------------------
        // * 그리디 알고리즘 사용
        // * 동전의 가치가 오름차순으로 주어지기 때문에,
        //   가장 큰 가치의 동전부터 사용해 금액을 채우면 됨
        // * 큰 동전부터 최대한 많이 사용하고 남은 금액을 그 다음 큰 동전 사용
        // * 위 과정을 반복해 최종적으로 K원을 만드는 데 필요한 동전의 최소 개수 구하기
        // ------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 입력을 받는다.
        int N = sc.nextInt();  // 동전 종류의 수
        int K = sc.nextInt();  // 목표 금액
        int[] coins = new int[N];   // 동전의 가치를 저장할 배열

        // 동전의 가치를 입력받는다.
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int count = 0;  // 필요한 동전의 개수를 세기 위한 변수

        // 그리디 알고리즘을 사용하여 큰 동전부터 차례대로 사용한다.
        for (int i = N - 1; i >= 0; i--) {
            if (coins[i] <= K) {  // 현재 동전의 가치가 목표 금액보다 작거나 같을 때만 사용
                count += K / coins[i];  // 현재 동전을 사용할 수 있는 최대 개수를 더함
                K %= coins[i];  // 목표 금액에서 사용한 동전의 금액을 뺌
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}