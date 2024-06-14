import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 5585: 거스름돈
        // 시간 복잡도:
        // --------------------------------------------------------------------
        // * 타로가 1000엔 지폐를 내고 물건을 살 때 받을 잔돈의 수를 최소로 만들어야 함
        // * 거스름돈으로 사용할 수 있는 동전은 500엔, 100엔, 50엔, 10엔, 5엔, 1엔
        // * 1000엔에서 타로가 내야 하는 금액을 빼서 거스름돈 계산
        // * 큰 단위의 동전부터 차례대로 사용해 거스름돈을 줄여야 받을 동전 개수를 최소화할 수 있음
        // * 각 동전을 사용할 수 있는 최대 계수를 계산하고 남은 금액에 대해 다음 동전 사용
        // --------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt(); // 타로가 지불해야 할 금액 입력받기
        sc.close();

        int change = 1000 - price; // 1000엔에서 타로가 지불해야 할 금액을 빼서 잔돈을 계산함
        int[] coins = {500, 100, 50, 10, 5, 1}; // 사용할 수 있는 동전 배열
        int coinCount = 0; // 동전 개수를 셀 변수 초기화

        // 잔돈을 최소 동전 개수로 주기 위해 큰 단위 동전부터 사용
        for (int coin : coins) {
            coinCount += change / coin; // 현재 동전으로 줄 수 있는 최대 개수 더하기
            change %= coin; // 현재 동전으로 나누고 남은 잔돈 계산
        }

        System.out.println(coinCount);
    }
}