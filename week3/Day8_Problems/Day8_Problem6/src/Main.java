import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 11399: ATM
        // ---------------------------------------------------------------
        // * 각 사람이 돈을 인출하는 데 걸리는 시간을 정렬하면 최소 대기 시간을 만들 수 있음
        // * 정렬된 시간을 기반으로 각 사람이 기다린 총 시간을 누적해 합산해야 함
        // * 위 과정을 위해 배열을 정렬하고 누적합을 계산해야 함
        // ---------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 사람의 수 N 입력
        int N = sc.nextInt();

        // 각 사람이 돈을 인출하는데 걸리는 시간 Pi 입력
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }

        // 2. 각 사람이 돈을 인출하는데 걸리는 시간 Pi를 정렬
        Arrays.sort(P);

        // 3. 각 사람이 돈을 인출하는데 필요한 시간의 합 계산
        int totalTime = 0;
        int currentSum = 0;
        for (int i = 0; i < N; i++) {
            // 현재 사람까지의 대기 시간 누적
            currentSum += P[i];
            // 총 대기 시간에 현재까지의 대기 시간 더하기
            totalTime += currentSum;
        }

        // 결과 출력
        System.out.println(totalTime);
    }
}