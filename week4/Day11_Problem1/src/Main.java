import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2798: 블랙잭
        // ---------------------------------------------------
        // * 카드 3 장을 선택하는 모든 조합을 생성하고,
        //   각 조합의 합이 M을 넘지 않으며 최대한 가까운 값을 찾아야 함
        // ---------------------------------------------------

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 카드 개수
        int M = sc.nextInt(); // 목표 값
        int[] cards = new int[N]; // 카드 리스트

        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        int maxSum = 0; // M을 넘지 않으며 M에 가장 가까운 합

        // 카드 3 장의 모든 조합 생성
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    // 조합의 합 계산
                    int sum = cards[i] + cards[j] + cards[k];
                    // 합이 M을 넘지 않는 최대 값 갱신
                    if (sum <= M && sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }

        System.out.println(maxSum);
    }
}