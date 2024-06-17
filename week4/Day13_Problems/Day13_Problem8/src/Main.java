import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 백준 1916: 최소 비용 구하기
        // ----------------------
        // * 다익스트라 알고리즘 사용
        // * 우선순위 큐 사용
        // ----------------------

        Scanner sc = new Scanner(System.in);

        // 도시의 개수 N과 버스의 개수 M을 입력받음
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 그래프를 표현하기 위한 인접 리스트를 선언
        List<List<Nodes>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 각 버스의 정보 (출발 도시, 도착 도시, 비용)를 입력받아 그래프에 추가
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(start).add(new Nodes(end, cost));
        }

        // 출발점과 도착점을 입력받음
        int startCity = sc.nextInt();
        int endCity = sc.nextInt();

        // 다익스트라 알고리즘을 사용하여 최단 경로를 계산하고 결과를 출력
        int result = dijkstra(graph, startCity, endCity, N);
        System.out.println(result);
    }

    // 다익스트라 알고리즘을 구현한 함수
    public static int dijkstra(List<List<Nodes>> graph, int start, int end, int N) {
        // 최단 거리 값을 저장하기 위한 배열을 선언하고 무한대로 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 우선순위 큐를 사용하여 최소 비용을 가지는 노드를 우선적으로 처리
        PriorityQueue<Nodes> pq = new PriorityQueue<>();
        pq.offer(new Nodes(start, 0));

        while (!pq.isEmpty()) {
            Nodes currentNode = pq.poll();
            int current = currentNode.city;
            int currentCost = currentNode.cost;

            // 현재 노드의 비용이 이미 저장된 최단 거리보다 크다면 무시
            if (currentCost > dist[current]) {
                continue;
            }

            // 인접한 노드들을 탐색하여 최단 거리를 갱신
            for (Nodes neighbor : graph.get(current)) {
                int next = neighbor.city;
                int nextCost = currentCost + neighbor.cost;

                // 더 짧은 경로를 발견하면 최단 거리를 갱신하고 우선순위 큐에 추가
                if (nextCost < dist[next]) {
                    dist[next] = nextCost;
                    pq.offer(new Nodes(next, nextCost));
                }
            }
        }

        // 도착점의 최단 거리를 반환
        return dist[end];
    }
}

// 그래프의 노드를 나타내는 클래스
class Nodes implements Comparable<Nodes> {
    int city;
    int cost;

    Nodes(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    @Override
    public int compareTo(Nodes other) {
        return Integer.compare(this.cost, other.cost);
    }
}
