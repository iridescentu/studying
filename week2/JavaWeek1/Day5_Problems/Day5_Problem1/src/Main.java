import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2738: 행렬 덧셈
        Scanner sc = new Scanner(System.in);

        // * 입력받은 N과 M을 이용해 행렬의 크기를 결정한다.
        int N = sc.nextInt();
        int M = sc.nextInt();

        // * 두 행렬 A와 B를 저장할 2차원 배열을 선언한다.
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        // * 행렬 A의 원소를 입력받는다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // * 행렬 B의 원소를 입력받는다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // * 행렬 A와 B를 더하는 과정
        // ---------------------------------------------------------
        // * 두 행렬의 동일한 위치에 있는 원소들을 더해 새로운 행렬의 원소로 설정한다.
        // * 이중 for문을 사용하여 행렬의 모든 위치를 순회한다.
        // ---------------------------------------------------------
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // * A[i][j]와 B[i][j]를 더해 출력한다. 공백으로 원소를 구분한다.
                System.out.print((A[i][j] + B[i][j]) + " ");
            }
            // * 한 행의 출력이 끝나면 줄바꿈을 해 다음 행을 출력할 준비를 한다.
            System.out.println();
        }

        sc.close();    }
}