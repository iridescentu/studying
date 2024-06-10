import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 백준 2644: 촌수계산
        // ----------------------------------------------------------
        // * 그래프 탐색 문제
        // * 정점: 사람
        // * 간선: 부모 자식 관계
        // * 두 사람 간 최단 경로를 찾기 위해 BFS 사용
        // * BFS를 통해 시작점에서 목표점까지 최단 거리 구하기
        // * BFS 탐색 중간에 두 사람 간의 경로가 존재하지 않을 때에는 -1 반환하기
        // ----------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 전체 사람의 수
        int personA = sc.nextInt(); // 촌수를 계산해야 하는 첫 번째 사람
        int personB = sc.nextInt(); // 촌수를 계산해야 하는 두 번째 사람
        int m = sc.nextInt(); // 부모 자식 관계의 수

        List<Integer>[] graph = new ArrayList[n + 1]; // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            graph[parent].add(child); // 부모 -> 자식
            graph[child].add(parent); // 자식 -> 부모 (양방향 그래프)
        }

        int result = calculateChonSu(graph, personA, personB, n);
        System.out.println(result);
    }

    // BFS를 사용하여 두 사람 간의 촌수를 계산하는 함수
    public static int calculateChonSu(List<Integer>[] graph, int start, int goal, int n) {
        boolean[] visited = new boolean[n + 1]; // 방문 여부를 체크하기 위한 배열
        Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐
        queue.offer(new int[]{start, 0}); // 시작점과 촌수(0)을 큐에 삽입

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int person = current[0];
            int chonSu = current[1];

            if (person == goal) {
                return chonSu; // 목표 지점에 도달하면 촌수를 반환
            }

            for (int relative : graph[person]) {
                if (!visited[relative]) {
                    visited[relative] = true; // 방문 표시
                    queue.offer(new int[]{relative, chonSu + 1}); // 다음 탐색을 위해 큐에 삽입
                }
            }
        }

        return -1; // 목표 지점에 도달할 수 없으면 -1 반환
    }
}