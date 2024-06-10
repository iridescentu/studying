// 백준 7562: 나이트의 이동
// -----------------------------------------------
// * 체스판 위에서 나이트가 이동할 수 있는 최소 횟수 구하기
// * BFS를 사용해 최단 경로 찾기
// * 나이트는 8 가지 이동 패턴을 가짐
// * 체스판의 크기와 나이트의 시작점, 목적지점을 입력으로 받음
// * BFS를 사용해 최소 이동 횟수 계산하기
// -----------------------------------------------

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 나이트의 8가지 이동 패턴 정의
    private static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt(); // 테스트 케이스의 개수 입력

        for (int t = 0; t < testCases; t++) {
            int l = sc.nextInt(); // 체스판의 크기 입력
            int startX = sc.nextInt(); // 나이트의 시작 위치 X좌표
            int startY = sc.nextInt(); // 나이트의 시작 위치 Y좌표
            int endX = sc.nextInt(); // 나이트가 이동하려는 위치 X좌표
            int endY = sc.nextInt(); // 나이트가 이동하려는 위치 Y좌표

            // BFS를 사용하여 최소 이동 횟수를 계산하고 출력
            System.out.println(bfs(l, startX, startY, endX, endY));
        }
        sc.close();
    }

    // BFS 알고리즘을 사용하여 최단 경로를 찾는 메서드
    private static int bfs(int l, int startX, int startY, int endX, int endY) {
        // 방문 여부를 저장하는 배열
        boolean[][] visited = new boolean[l][l];
        // BFS 탐색을 위한 큐 생성
        Queue<int[]> queue = new LinkedList<>();
        // 시작 위치를 큐에 추가하고 방문 표시
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐에서 현재 위치를 꺼냄
            int x = current[0];
            int y = current[1];
            int moves = current[2]; // 현재까지의 이동 횟수

            // 목적지에 도달하면 이동 횟수 반환
            if (x == endX && y == endY) {
                return moves;
            }

            // 나이트의 8가지 이동 패턴을 모두 검사
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 체스판 범위 내에 있고, 방문하지 않은 위치라면 큐에 추가
                if (nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, moves + 1});
                    visited[nx][ny] = true; // 방문 표시
                }
            }
        }

        // 도달할 수 없는 경우는 없으니 기본적으로 반환하지 않음
        return -1;
    }
}