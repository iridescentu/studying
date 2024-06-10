import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 백준 24444: 알고리즘 수업 - 너비 우선 탐색 1
        // ----------------------------------------------------------
        // * BFS를 사용해 그래프를 탐색하고 방문 순서 기록하기
        // * BFS 구현을 위해 큐 자료구조 사용
        // * 정점과 간선 정보를 입력받고, 그래프를 인접 리스트 형태로 저장해야 함
        // * 시작 정점 R에서 BFS를 시작해 방문 순서 기록
        // * 방문하지 않은 정점은 0으로 표시
        // * 인접 정점은 오름차순으로 방문해야 하기 때문에 인접 리스트를 정렬해야 함
        // ----------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 정점의 수 N, 간선의 수 M, 시작 정점 R 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        // 그래프를 인접 리스트로 표현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 인접 정점 오름차순 방문을 위해 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // 방문 순서를 저장할 배열
        int[] order = new int[N + 1];
        // 방문 여부를 체크할 배열
        boolean[] visited = new boolean[N + 1];
        // BFS를 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        // 방문 순서를 기록할 변수
        int sequence = 1;

        // 시작 정점 R을 큐에 추가하고 방문 표시
        queue.add(R);
        visited[R] = true;
        order[R] = sequence++;

        // BFS 알고리즘 수행
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    order[v] = sequence++;
                    queue.add(v);
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }
}