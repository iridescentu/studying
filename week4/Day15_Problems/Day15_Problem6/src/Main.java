import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2512: 예산
        // -----------------------------------------------------------------
        // * 이진 탐색 사용
        // * 상한액을 설정해 예산을 배정하는 문제이기 때문에 상한액을 이진 탐색으로 찾아야 함
        // * 1) 예산 요청의 최대값 구하기
        // * 2) 이진 탐색을 사용해 상한액을 조정하며 총 예산을 초과하지 않는 최대 상한액 찾기
        // -----------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 입력받기
        int N = sc.nextInt(); // 지방의 수
        int[] requests = new int[N]; // 각 지방의 예산 요청 배열
        for (int i = 0; i < N; i++) {
            requests[i] = sc.nextInt();
        }
        int M = sc.nextInt(); // 총 예산

        // 예산 요청 배열을 정렬하여 최대값을 구함
        Arrays.sort(requests);

        // 이진 탐색을 위한 변수 초기화
        int low = 0;
        int high = requests[N - 1]; // 예산 요청의 최대값
        int result = 0;

        // 이진 탐색 시작
        while (low <= high) {
            int mid = (low + high) / 2; // 중간값을 상한액으로 설정
            long total = 0;

            // 현재 상한액(mid)으로 총 배정된 예산 계산
            for (int request : requests) {
                if (request > mid) {
                    total += mid; // 상한액보다 큰 요청은 상한액으로 배정
                } else {
                    total += request; // 상한액 이하의 요청은 그대로 배정
                }
            }

            // 총 배정된 예산이 주어진 예산(M)을 초과하는지 확인
            if (total <= M) {
                result = mid; // 상한액을 늘려도 되니 현재 상한액을 결과로 저장
                low = mid + 1; // 상한액을 더 높여 봄
            } else {
                high = mid - 1; // 상한액을 줄임
            }
        }

        // 최종 상한액 출력
        System.out.println(result);
    }
}