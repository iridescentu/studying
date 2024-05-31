import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 24263: 알고리즘 수업 - 알고리즘의 수행 시간 2
        // -----------------------------------------------------------
        // * 주어진 입력 크기 n에 대한 알고리즘의 수행 횟수를 계산하고 출력해야 한다.
        // * 알고리즘은 주어진 배열 A의 요소를 합산하는 단순한 반복문을 사용.
        // * 입력의 크기 n이 주어지면, 반복문은 n번 수행되므로 수행 횟수는 n이 된다.
        // * 반복문의 수행 횟수는 n에 비례하므로 알고리즘의 시간 복잡도는 0(n)이다.
        // * 따라서, 최고차항의 차수는 1이 된다.
        // -----------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(n);

        System.out.println(1);
    }
}