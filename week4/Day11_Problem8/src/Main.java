// 백준 1182: 부분수열의 합
// -----------------------------------------------------------------------
// * 부분수열의 합이 특정 값이 되는 경우의 수를 구하는 문제
// * 부분수열의 경우의 수를 구할 때는 재귀를 사용해 모든 부분수열을 탐색하는 것이 좋음
// * 주어진 수열에서 각 원소를 포함/포함하지 않는 두 가지 선택지가 있으니 재귀적으로 구현 가능
// -----------------------------------------------------------------------

import java.util.Scanner;

public class Main {
    // 결과 저장할 변수
    static int count = 0;
    // 목표 합
    static int S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        S = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 부분수열 탐색하는 재귀 함수 호출
        findSub(arr, 0, 0, 0);

        System.out.println(count);
        sc.close();
    }

    // 부분수열의 합이 S가 되는 경우의 수 찾기
    public static void findSub(int[] arr, int index, int currentSum, int length) {
        // 종료 조건: 배열의 끝에 도달했을 때
        if (index == arr.length) {
            // 현재 부분합이 S와 같다면 카운트 증가
            if (currentSum == S && length > 0) {
                count++;
            }
            return;
        }

        // 현재 원소를 포함 X
        findSub(arr, index + 1, currentSum, length);

        // 현재 원소를 포함
        findSub(arr, index + 1, currentSum + arr[index], length + 1);
    }
}