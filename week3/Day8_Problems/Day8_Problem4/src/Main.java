import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2805: 나무 자르기
        // ----------------------------------------------------------------------------
        // * 이분 탐색을 사용해 절단기의 높이를 조정하면서 적어도 M미터의 나무를 얻을 수 있는 최대 높이 찾기
        // * 나무의 최대 높이를 구하고 이분 탐색의 상한으로 설정
        // * 이분 탐색을 통해 절단기의 높이 H를 조정하면서 현재 높이에서 얻을 수 있는 나무의 길이 계산
        // * 얻은 나무의 길이가 M 이상이면 더 높은 높이로 절단기 설정, 그렇지 않으면 낮은 높이로 설정
        // * 위 과정을 반복하며 절단기 높이 H의 최댓값 찾기
        // ----------------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 나무의 수
        int M = sc.nextInt(); // 필요한 나무 길이
        int[] heights = new int[N]; // 나무 높이 배열

        int maxHeight = 0; // 나무의 최대 높이를 저장할 변수
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
            if (heights[i] > maxHeight) {
                maxHeight = heights[i]; // 나무의 최대 높이 업데이트
            }
        }

        // 이분 탐색 초기 설정
        int low = 0;
        int high = maxHeight;
        int result = 0;

        // 이분 탐색
        while (low <= high) {
            int mid = (low + high) / 2; // 절단기의 중간 높이 설정

            // 현재 높이에서 얻을 수 있는 나무의 길이 계산
            long totalWood = 0; // 얻을 수 있는 나무의 총 길이
            for (int height : heights) {
                if (height > mid) {
                    totalWood += (height - mid); // 절단된 나무 길이 추가
                }
            }

            // 얻은 나무의 길이가 필요한 나무의 길이 M 이상인지 확인
            if (totalWood >= M) {
                result = mid; // 가능한 절단기 높이 업데이트
                low = mid + 1; // 더 높은 높이로 탐색
            } else {
                high = mid - 1; // 더 낮은 높이로 탐색
            }
        }

        System.out.println(result);
    }
}