import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2441: 별 찍기 4
        // -------------------------------------------------
        // * 주어진 수 N에 따라 감소하는 별의 수 출력하기
        // * 각 줄마다 별의 수는 1씩 감소하고, 공백의 수는 1씩 증가
        // * 별과 공백의 변화 패턴을 이해하기
        // * 반복문을 사용해 각 줄마ㅏㄷ 별과 공백을 적절한 수로 출력하기
        // -------------------------------------------------

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = N; i > 0; i--) {
            // 공백 출력
            for (int j = 0; j < N - i; j++) { // N - i만큼 공백 출력
                System.out.print(" ");
            }
            // 별 출력
            for (int k = 0; k < i; k++) { // i만큼 별 출력
                System.out.print("*");
            }
            System.out.println();
        }
    }
}