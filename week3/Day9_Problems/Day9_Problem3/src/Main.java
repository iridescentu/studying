import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 28417: 스케이트보드
        // ---------------------------------------------------------
        // * 두 번의 런 점수 중 최고 점수를 찾아야 함
        // * Arrays.sort 메소드를 사용해 점수를 오름차순으로 정렬하기
        // * 최종 점수를 계산하기 위해 필요한 점수들을 합산
        // ---------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 참가자 수 입력받기
        int maxScore = 0; // 최고 점수 저장할 변수 초기화

        for (int i = 0; i < N; i++) {
            int[] scores = new int[7]; // 런과 트릭 점수를 저장할 배열
            for (int j = 0; j < 7; j++) {
                scores[j] = sc.nextInt(); // 점수 입력받기
            }

            maxScore = Math.max(maxScore, calculateFinalScore(scores)); // 각 참가자의 최종 점수를 계산해 최고 점수 갱신
        }

        System.out.println(maxScore); // 최고 점수 출력
    }

    private static int calculateFinalScore(int[] scores) {
        int runMaxScores = Math.max(scores[0], scores[1]); // 런 점수 중 최고 점수 계산
        int[] trickScores = Arrays.copyOfRange(scores, 2, 7); // 트릭 점수 배열 복사
        Arrays.sort(trickScores); // 트릭 점수를 오름차순으로 정렬
        return runMaxScores + trickScores[3] + trickScores[4];
    }
}