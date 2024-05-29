import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2445: 별 찍기 8
        // ---------------------------------------------------------
        // * 입력된 값 N에 따라 별(*) 패턴을 출력하는 문제이다.
        // * 출력 패턴은 N줄의 증가하는 별과 N-1줄의 감소하는 별로 구성되어 있다.
        // * 각 줄의 별 사이에는 공백이 있으며, 공백의 개수는 줄 번호에 따라 달라진다.
        // * for 반복문을 사용하여 각 줄의 별과 공백을 출력한다.
        // ---------------------------------------------------------

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // 첫 번째 반: 줄번호에 따라 별의 개수가 증가하는 부분
        for (int i = 1; i <= N; i++) {
            // 별을 출력하는 부분
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // 공백을 출력하는 부분
            for (int j = 1; j <= 2 * (N - i); j++) {
                System.out.print(" ");
            }
            // 다시 별을 출력하는 부분
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); // 줄 바꿈
        }

        // 두 번째 반: 줄번호에 따라 별의 개수가 감소하는 부분
        for (int i = N - 1; i >= 1; i--) {
            // 별을 출력하는 부분
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // 공백을 출력하는 부분
            for (int j = 1; j <= 2 * (N - i); j++) {
                System.out.print(" ");
            }
            // 다시 별을 출력하는 부분
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(); // 줄 바꿈
        }
    }
}