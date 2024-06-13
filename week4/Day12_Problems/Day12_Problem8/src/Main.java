// 백준 17086: 아기 상어 2
// 시간 복잡도:
// --------------------------------------------------------------------------
// * 주어진 공간의 크기 N, M과 공간의 상태를 입력받아 grid 배열에 저장
// * 아기 상어가 있는 칸의 좌표를 큐에 저장
// * BFS 탐색을 위해 8방향으로 이동할 수 있는 배열 dx, dy 정의
// * 큐에서 아기 상어 위치를 하나씩 꺼내 8방향으로 이동, 방문하지 않은 칸에 대해 거리 갱신
// --------------------------------------------------------------------------

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] grid = new int[N][M];

        // 아기 상어의 위치를 저장할 큐
        Queue<int[]> queue = new LinkedList<>();

        // 공간의 상태를 입력받는다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    // 아기 상어의 위치를 큐에 추가
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 8방향 이동을 위한 배열
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        // BFS를 통해 각 칸의 안전 거리를 계산
        int maxDistance = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 유효한 범위 내이고, 아직 방문하지 않은 칸
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && grid[nx][ny] == 0) {
                    grid[nx][ny] = grid[x][y] + 1;  // 거리 갱신
                    maxDistance = Math.max(maxDistance, grid[nx][ny]);
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        // 출력: 최대 안전 거리
        System.out.println(maxDistance - 1); // 초기값이 1이므로 1을 빼줌
    }
}