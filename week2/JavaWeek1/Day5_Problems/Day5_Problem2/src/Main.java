import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2566: 최댓값

        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[9][9]; // 9x9 격자판을 저장할 배열
        int max = Integer.MIN_VALUE; // 최댓값을 저장할 변수, 가장 작은 값으로 초기화
        int maxRow = 0; // 최댓값의 행 위치
        int maxCol = 0; // 최댓값의 열 위치

        // 격자판 입력 받기
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = sc.nextInt();
                // 최댓값 찾기
                if (grid[i][j] > max) {
                    max = grid[i][j]; // 최댓값 갱신
                    maxRow = i + 1; // 행 위치 갱신, 인덱스는 0부터 시작하므로 1을 더해줌
                    maxCol = j + 1; // 열 위치 갱신, 마찬가지로 인덱스는 0부터 시작하므로 1을 더해줌
                }
            }
        }

        // 결과 출력
        System.out.println(max);
        System.out.println(maxRow + " " + maxCol);

        sc.close();
    }
}