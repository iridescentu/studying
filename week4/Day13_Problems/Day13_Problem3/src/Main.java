import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 14720: 우유 축제
        // 시간 복잡도: O(N)
        // -----------------------------------------------------------------------
        // * 마실 수 있는 우유의 순서: 딸기(0) -> 초코(1) -> 바나나(2) -> 딸기(0) 순으로 반복됨
        // * 주어진 우유 가게 정보를 순회하면서 마실 수 있는 우유를 체크해야 함
        // * 마셔야 할 우유의 종류를 찾기 위해 currentMilk 변수 사용했음
        // * 우유 가게를 순회하면서 currentMilk와 일치하는 우유 가게가 있으면 우유를 마시고,
        //   currentMilk를 다음 우유 종류로 업데이트해 줌
        // * 이 과정을 반복하며 마실 수 있는 최대 우유 개수를 계산해야 함
        // -----------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 우유 가게의 수 N 입력받기

        // 우유 가게 정보를 입력받아 배열에 저장
        int[] milkStores = new int[N];
        for (int i = 0; i < N; i++) {
            milkStores[i] = sc.nextInt();
        }
        sc.close();

        // 마셔야 할 현재 우유의 종류를 나타내는 변수
        int currentMilk = 0; // 0: 딸기우유, 1: 초코우유, 2: 바나나우유
        int milkCount = 0; // 마신 우유의 개수를 저장하는 변수

        // 우유 가게 순회
        for (int i = 0; i < N; i++) {
            // 현재 우유 가게에서 파는 우유가 마셔야 할 우유의 종류와 일치하는지 확인
            if (milkStores[i] == currentMilk) {
                milkCount++; // 우유 마시기
                currentMilk = (currentMilk + 1) % 3; // 다음에 마셔야 할 우유의 종류로 업데이트
            }
        }

        // 마실 수 있는 최대 우유 개수 출력
        System.out.println(milkCount);
    }
}