import java.util.*;

// 백준 1504: 특정한 최단 경로
// 시간 복잡도:
// ----------------------------------------------------------
// * 시작점(1번 정점)에서 모든 정점까지의 최단 경로
// * 반드시 거쳐야 하는 두 정점(v1, v2) 각각에서 모든 정점까지의 최단 경로
// * 1 -> v1 -> v2 -> N
// * 1 -> v2 -> v1 -> N
// * 위의 두 경로 중 더 짧은 경로를 선택
// ----------------------------------------------------------

public class Main {
    static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    static final int INF = 200000000; // 충분히 큰 값으로 무한대를 설정
    static List<List<Node>> graph;
    static int N, E;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정점의 개수 N과 간선의 개수 E 입력받기
        N = sc.nextInt();
        E = sc.nextInt();

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력받기
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // 양방향 그래프이므로 양쪽에 간선 추가
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        // 반드시 거쳐야 하는 두 정점 v1과 v2
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        // 1번 정점에서 모든 정점까지의 최단 거리
        int[] distFrom1 = dijkstra(1);
        // v1 정점에서 모든 정점까지의 최단 거리
        int[] distFromV1 = dijkstra(v1);
        // v2 정점에서 모든 정점까지의 최단 거리
        int[] distFromV2 = dijkstra(v2);

        // 1 -> v1 -> v2 -> N 경로의 거리 계산
        int path1 = distFrom1[v1] + distFromV1[v2] + distFromV2[N];
        // 1 -> v2 -> v1 -> N 경로의 거리 계산
        int path2 = distFrom1[v2] + distFromV2[v1] + distFromV1[N];

        // 두 경로 중 더 짧은 경로 선택
        int result = Math.min(path1, path2);

        // 경로가 존재하지 않으면 -1 출력
        if (result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    // 다익스트라 알고리즘 구현
    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (dist[current.vertex] < current.cost) continue;

            for (Node next : graph.get(current.vertex)) {
                int newDist = dist[current.vertex] + next.cost;

                if (newDist < dist[next.vertex]) {
                    dist[next.vertex] = newDist;
                    pq.add(new Node(next.vertex, newDist));
                }
            }
        }

        return dist;
    }
}