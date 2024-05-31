import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 24265: 알고리즘 수업 - 알고리즘의 수행 시간 4
        // -----------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 코드 1의 수행 횟수를 계산한다.
        // sum은 1부터 n-1까지의 합이므로, 등차수열의 한 공식을 사용한다.
        long sum = (long) n * (n - 1) / 2;

        // 첫째 줄에는 코드 1의 수행 횟수를 출력한다.
        System.out.println(sum);

        // 둘째 줄에는 최고차항의 차수를 출력한다.
        // 이 경우, 차수는 2이므로 2를 출력한다.
        System.out.println(2);
    }
}