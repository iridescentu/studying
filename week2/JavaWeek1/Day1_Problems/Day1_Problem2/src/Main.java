import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2480: 주사위 세 개
        // * 주사위의 눈이 같은지/다른지 판별해야 하고 그에 따라 상금 계산 방법을 고려해야 함.

        Scanner scanner = new Scanner(System.in);

        // 주사위 눈을 입력받는다
        int dice1 = scanner.nextInt();
        int dice2 = scanner.nextInt();
        int dice3 = scanner.nextInt();

        // 상금을 저장할 변수
        int prize = 0;

        if (dice1 == dice2 && dice2 == dice3) { // 주사위 눈이 모두 같은 경우
            prize = 10000 + dice1 * 1000;
        } else if (dice1 == dice2 || dice1 == dice3) { // 주사위 눈이 두 개만 같은 경우 (첫 번째 주사위 기준)
            prize = 1000 + dice1 * 100;
        } else if (dice2 == dice3) { // 주사위 눈이 두 개만 같은 경우 (두 번째, 세 번째 주사위 기준)
            prize = 1000 + dice2 * 100;
        } else { // 주사위의 눈이 모두 다른 경우
            // 가장 큰 눈을 찾는다
            int maxDice = Math.max(dice1, Math.max(dice2, dice3));
            prize = maxDice * 100;
        }

        // 계산된 상금 출력하기
        System.out.println(prize);
    }
}