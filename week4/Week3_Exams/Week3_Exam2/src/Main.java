import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2212: 센서
        // ------------------------------------------------------------
        // * 그리디 알고리즘 사용
        // * 센서들을 정렬하고 가까운 센서들 간의 거리 차이 계산
        // * K개의 집중국을 설치할 수 있기 때문에 K-1개의 가장 큰 거리 차이를 제외하고,
        //   나머지 거리의 합을 구해야 됨
        // * 최소한의 수신 가능 영역 길이 합을 구하는 데 도움이 됨
        // ------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 입력받기
        int N = sc.nextInt(); // 센서 개수
        int K = sc.nextInt(); // 집중국 개수
        int[] sensors = new int[N];

        for (int i = 0; i < N; i++) {
            sensors[i] = sc.nextInt();
        }

        // 센서 위치 정렬
        Arrays.sort(sensors);

        // 가까운 센서들 사이의 거리 차이 계산
        int[] distances = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        // 거리 차이를 내림차순으로 정렬
        Arrays.sort(distances);

        // 가장 큰 거리 차이 K-1개를 제외하고 나머지 거리 차이의 합 구하기
        int min = 0;
        for (int i = 0; i < N - K; i++) {
            min += distances[i];
        }

        System.out.println(min);

        sc.close();
    }
}