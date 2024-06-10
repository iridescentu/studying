import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 24479: 알고리즘 수업 - 깊이 우선 탐색 1
        // ------------------------------------
        // * 그래프를 인접 리스트로 표현
        // * 방문 여부를 확인할 visited 배열
        // * 각 정점의 방문 순서를 저장할 order 배열
        // ------------------------------------

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점의 수
        int M = sc.nextInt(); // 간선의 수
        int R = sc.nextInt(); // 시작 정점

        // * 그래프를 인접 리스트로 표현
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // * 간선 정보를 입력받아 그래프 구성
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // * 정점의 인접 정점들을 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        boolean[] visited = new boolean[N + 1]; // 방문 여부를 확인할 배열
        int[] order = new int[N + 1]; // 방문 순서를 저장할 배열
        int[] count = {0}; // 방문 순서를 기록할 카운트

        // DFS 수행
        dfs(R, graph, visited, order, count);

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }

    // DFS 함수
    public static void dfs(int node, List<Integer>[] graph, boolean[] visited, int[] order, int[] count) {
        visited[node] = true; // 현재 노드를 방문했다고 표시
        order[node] = ++count[0]; // 방문 순서 기록

        // 인접한 노드들을 오름차순으로 방문
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, graph, visited, order, count);
            }
        }
    }
}