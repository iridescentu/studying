import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 백준 10282: 해킹
        // ----------------------------------------------------------
        // * 다익스트라: 한 정점에서 다른 모든 정점으로의 최단 경로를 구하는 알고리즘
        // * 해킹당한 컴퓨터를 시작점으로 다른 모든 컴퓨터로의 최단 시간을 구하고,
        //   감염된 컴퓨터 수와 가장 오래 걸리는 시간 계산하기
        // ----------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스의 개수

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); // 컴퓨터의 개수
            int d = sc.nextInt(); // 의존성의 개수
            int c = sc.nextInt(); // 해킹당한 컴퓨터의 번호

            List<List<Pair>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < d; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int s = sc.nextInt();
                graph.get(b).add(new Pair(a, s)); // b가 감염되면 s초 후 a도 감염됨
            }

            // 다익스트라 알고리즘을 사용하여 해킹당한 컴퓨터로부터의 최단 시간을 구한다.
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[c] = 0;

            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.time));
            pq.add(new Pair(c, 0));

            while (!pq.isEmpty()) {
                Pair current = pq.poll();
                int currentNode = current.node;
                int currentTime = current.time;

                if (currentTime > dist[currentNode]) continue;

                for (Pair neighbor : graph.get(currentNode)) {
                    int nextNode = neighbor.node;
                    int newTime = currentTime + neighbor.time;

                    if (newTime < dist[nextNode]) {
                        dist[nextNode] = newTime;
                        pq.add(new Pair(nextNode, newTime));
                    }
                }
            }

            int count = 0;
            int maxTime = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[j] != Integer.MAX_VALUE) {
                    count++;
                    maxTime = Math.max(maxTime, dist[j]);
                }
            }

            System.out.println(count + " " + maxTime);
        }

        sc.close();
    }

    static class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
}
