import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1546: 평균
        // -------------------------------------------------------


        Scanner sc = new Scanner(System.in);

        // 1. 입력 받기
        int N = sc.nextInt(); // 시험 본 과목의 개수 N
        double[] scores = new double[N]; // N개의 점수를 저장할 배열
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextDouble(); // 점수 입력 받기
        }

        // 2. 최댓값 찾기
        double maxScore = 0;
        for (double score : scores) {
            if (score > maxScore) {
                maxScore = score; // 최댓값 갱신
            }
        }

        // 3. 새로운 점수 계산
        double sum = 0; // 변환된 점수들의 합
        for (int i = 0; i < N; i++) {
            scores[i] = scores[i] / maxScore * 100; // 새로운 점수로 변환
            sum += scores[i]; // 변환된 점수들의 합 계산
        }

        // 4. 새로운 평균 계산
        double newAverage = sum / N; // 새로운 평균 = 변환된 점수들의 합 / 과목 수

        // 5. 출력
        System.out.println(newAverage); // 새로운 평균 출력
    }
}