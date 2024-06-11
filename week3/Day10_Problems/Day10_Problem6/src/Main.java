import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2606: 바이러스
        // -----------------------------------------------
        // * 컴퓨터: 노드 / 연결: 간선
        // * 1번 컴퓨터부터 DFS 시작해 연결된 모든 컴퓨터 방문
        // * 이미 방문한 컴퓨터를 다시 방문하지 않도록 방문 여부 체크
        // * 1번 컴퓨터를 제외하고 방문한 컴퓨터의 수 출력
        // -----------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 1. 컴퓨터의 수 입력
        int numOfComputers = sc.nextInt();

        // 2. 네트워크 상의 직접 연결된 컴퓨터 쌍의 수 입력
        int numOfPairs = sc.nextInt();

        // 3. 그래프 표현을 위한 인접 리스트 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numOfComputers + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 4. 네트워크 연결 정보 입력 및 그래프 구성
        for (int i = 0; i < numOfPairs; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 5. 방문 여부를 체크할 배열 초기화
        boolean[] visited = new boolean[numOfComputers + 1];

        // 6. DFS를 통해 바이러스 전파 과정 실행
        int infectedCount = dfs(graph, visited, 1) - 1; // 1번 컴퓨터 제외

        // 7. 결과 출력
        System.out.println(infectedCount);
    }

    // DFS 함수
    private static int dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true; // 현재 노드 방문 체크
        int count = 1; // 현재 노드 포함

        // 현재 노드와 연결된 다른 노드들을 방문
        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) {
                count += dfs(graph, visited, nextNode);
            }
        }

        return count; // 총 방문한 노드의 수 반환
    }
}