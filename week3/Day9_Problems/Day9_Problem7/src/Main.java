import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1072: 게임
        // ------------------------------------------------
        // * X = 총 게임 횟수
        // * Y = 이긴 게임 횟수
        // * Z = 승률 -> Z = (Y * 100) / X
        // * Z를 증가시키기 위해 최소 몇 번 더 이겨야 하는지 구해야 함
        // ------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 입력 받기
        long X = sc.nextLong();
        long Y = sc.nextLong();

        // 현재 승률 계산
        long Z = (Y * 100) / X;

        // 승률이 99 이상이면 절대 변하지 않음
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        // 이분 탐색을 통해 최소 추가 게임 횟수 계산
        long left = 0;
        long right = 1000000000L; // 큰 수 설정
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long newWins = Y + mid;
            long newTotal = X + mid;
            long newZ = (newWins * 100) / newTotal;

            if (newZ > Z) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}