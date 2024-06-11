import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 11561: 징검다리
        // ---------------------------------------------------------------------------------
        // * 첫 번째 점프에서 아무 징검다리나 밟을 수 있고, 다음 점프는 이전 점프보다 1 이상 더 긴 거리를 뛰어야 함
        // * N번 징검다리를 "반드시" 밟아야 함
        // * 밟을 수 있는 최대 징검다리 수를 구해야 함
        // ---------------------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 수 입력
        int T = sc.nextInt();
        long[] N = new long[T];

        // 각 테스트 케이스의 N값 입력
        for (int i = 0; i < T; i++) {
            N[i] = sc.nextLong();
        }

        // 각 테스트 케이스에 대해 결과 출력
        for (int i = 0; i < T; i++) {
            System.out.println(maxSteppingStones(N[i]));
        }

        sc.close();
    }

    // 최대 징검다리 수를 계산하는 함수
    public static long maxSteppingStones(long N) {
        // 이진 탐색을 위한 변수 초기화
        long left = 1, right = (long) Math.sqrt(2 * N); // 적절한 범위 설정
        long result = 1; // 결과 변수 초기화

        // 이진 탐색 수행
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = mid * (mid + 1) / 2; // 1부터 mid까지의 합 계산

            if (sum <= N) {
                result = mid; // 조건을 만족하면 결과 갱신
                left = mid + 1; // 더 큰 값을 탐색
            } else {
                right = mid - 1; // 더 작은 값을 탐색
            }
        }

        return result; // 결과 반환
    }
}