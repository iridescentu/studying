import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1697: 숨바꼭질
        // ------------------------------------------------------------------------------
        // * 수빈이가 이동할 수 있는 방법은 세 가지이다.
        //    - X-1, X+1, 2*X
        // * BFS를 사용해 각 위치에서 이동할 수 있는 모든 경우를 탐색하고, 가장 빠른 시간을 찾아야 함.
        // * BFS는 큐를 사용해 현재 위치에서 이동할 수 있는 모든 경우를 저장하고, 각 경우를 하나씩 꺼내 처리.
        // ------------------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 입력받기
        int N = sc.nextInt(); // 수빈이 위치
        int K = sc.nextInt(); // 동생 위치

        // BFS를 위한 큐와 방문 배열 초기화
        Queue<int []> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        // 초기 위치, 시간을 큐에 추가
        queue.add(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 위치, 시간을 큐에서 꺼내기
            int position = current[0];
            int time = current[1];

            // 동생의 위치에 도달하면 시간 출력
            if (position == K) {
                System.out.println(time);
                return;
            }

            // 세 가지 이동 방법에 대해 검사
            // 1. X-1로 이동
            if (position - 1 >= 0 && !visited[position - 1]) {
                queue.add(new int[]{position - 1, time + 1});
                visited[position - 1] = true;
            }

            // 2. X+1로 이동
            if (position + 1 <= 100000 && !visited[position + 1]) {
                queue.add(new int[]{position + 1, time + 1});
                visited[position + 1] = true;
            }

            // 3. X*2로 이동
            if (position * 2 <= 100000 && !visited[position * 2]) {
                queue.add(new int[]{position * 2, time + 1});
                visited[position * 2] = true;
            }
        }
    }
}