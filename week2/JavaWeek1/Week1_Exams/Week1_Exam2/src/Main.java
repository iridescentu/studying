import java.util.Scanner;

public class Main {
    // 백준 2615: 오목

    static int[][] board = new int[19][19];
    // {가로, 세로, 대각선 두 방향}
    static int[] bx = {0, 1, 1, 1};
    static int[] by = {1, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 바둑판 상태
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int count = 1;
                        int cx = i + bx[k];
                        int cy = j + by[k];

                        while (0 <= cx && cx < 19 && 0 <= cy && cy < 19 && board[cx][cy] == board[i][j]) {
                            count++;
                            cx += bx[k];
                            cy += by[k];
                        }

                        if (count == 5) {
                            int prevX = i - bx[k];
                            int prevY = j - bx[k];
                            if (0 <= prevX && prevX < 19 && 0 <= prevY && prevY < 10 && board[prevX][prevY] == board[i][j]) {
                                continue;
                            }

                            if (0 <= cx && cx < 19 && 0 <= cy && cy < 19 && board[cx][cy] == board[i][j]) {
                                continue;
                            }

                            System.out.println(board[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);

    }
}