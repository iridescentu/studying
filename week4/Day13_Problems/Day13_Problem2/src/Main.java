import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 14659: 한조 서열정리 하고 옴 ㅋㅋ
        // 시간 복잡도: O(N)
        // -----------------------------------------------------------------
        // * 각 봉우리마다 활잡이가 있고 용은 자신보다 낮은 봉우리에 있는 적들만 처치할 수 있음
        // * 더 높은 봉우리를 만나면 공격을 포기
        // * 목표: 각 봉우리마다 자신이 처치할 수 있는 적의 최대 숫자를 계산하고 최대값 찾기
        // -----------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 봉우리의 수 N 입력받기

        // 봉우리의 높이를 입력받아 배열에 저장
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }

        // 최대 처치할 수 있는 적의 수를 저장할 변수
        int maxKill = 0;

        // 현재 봉우리에서의 처치할 수 있는 적의 수를 저장할 변수
        int currentKill = 0;

        // 현재 최고 높이의 봉우리
        int currentMaxHeight = heights[0];

        // 첫 번째 봉우리는 처리할 필요가 없으므로 두 번째 봉우리부터 탐색
        for (int i = 1; i < N; i++) {
            if (heights[i] > currentMaxHeight) {
                // 현재 봉우리가 이전 최고 높이보다 높은 경우
                currentMaxHeight = heights[i]; // 새로운 최고 높이로 갱신
                currentKill = 0; // 현재 봉우리에서의 처치 수 초기화
            } else {
                // 현재 봉우리가 이전 최고 높이보다 낮은 경우
                currentKill++; // 처치할 수 있는 적의 수 증가
                maxKill = Math.max(maxKill, currentKill); // 최대 처치 수 갱신
            }
        }

        System.out.println(maxKill);
    }
}