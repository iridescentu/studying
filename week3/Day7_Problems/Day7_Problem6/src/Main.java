import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1920: 수 찾기
        // ----------------------------------------------------------------
        // * 이진 탐색을 사용해 배열에서 특정 숫자가 존재하는지 확인
        // * 이진 탐색을 사용하기 위해서는 배열이 정렬되어 있어야 하기 때문에 배열을 정리해 줌
        // ----------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 입력받기
        int N = sc.nextInt(); // 배열의 크기
        int[] A = new int[N]; // 배열 선언
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt(); // 배열 요소 입력
        }

        int M = sc.nextInt(); // 확인할 숫자의 개수
        int[] queries = new int[M]; // 확인할 숫자들
        for (int i = 0; i < M; i++) {
            queries[i] = sc.nextInt(); // 확인할 숫자 입력
        }

        // 배열 정렬
        Arrays.sort(A);

        // 각 숫자에 대해 이진 탐색
        for (int i = 0; i < M; i++) {
            if (binarySearch(A, queries[i])) {
                System.out.println(1); // 존재하면 1 출력
            } else {
                System.out.println(0); // 존재하지 않으면 0 출력
            }
        }

        sc.close();
    }

    // 이진 탐색 함수
    public static boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 중간 인덱스 계산

            if (array[mid] == target) {
                return true; // 타겟을 찾으면 true 반환
            } else if (array[mid] < target) {
                left = mid + 1; // 타겟이 더 크면 오른쪽으로 이동
            } else {
                right = mid - 1; // 타겟이 더 작으면 왼쪽으로 이동
            }
        }

        return false; // 타겟을 찾지 못하면 false 반환
    }
}