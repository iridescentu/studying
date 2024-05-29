import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2438: 별 찍기 1
        // 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작
        // --------------------------------------------------------------
        // * 반복문을 사용해 사용자의 입력값 N번 반복하고, 각 반복마다 *을 찍는다.
        // * 반복문 내에서 또 다른 반복문을 사용해, 현재 반복 횟수만큼 *을 출력한다.
        // * 이중 반복문을 사용하는 이유는 첫 번째 반복문이 줄을 바꿔주는 역할을 하고, 두 번째 반복문이 해당 줄에 *을 찍어 주는 역할을 하기 때문.
        Scanner sc = new Scanner(System.in);

        // 사용자로부터 숫자 N을 입력받음
        int N = sc.nextInt();

        // 1부터 N까지 반복한다
        for(int i = 1; i <= N; i++) {
            // 이 반복문은 *을 찍는 역할을 한다
            for(int j = 1; j <= i; j++) {
                // *을 출력하고 줄바꿈은 하지 않는다
                System.out.print("*");
            }
            // 한 줄에 *을 다 찍었으면 줄을 바꾼다
            System.out.println();
        }
    }
}