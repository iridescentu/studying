import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 백준 18352: 특정 거리의 도시 찾기
        // ---------------------------------------------------------------
        // * 그래프 탐색 문제, BFS 사용
        // * 출발 도시 X에서 BFS 시작, 거리가 K인 도시에 도착할 때 그 도시를 기록해야 함
        // ---------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X 입력받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();

        // 인접 리스트를 사용하여 그래프 표현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 도로 정보 입력받기
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph.get(A).add(B);
        }

        // BFS를 위한 큐와 거리 배열 초기화
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);

        // 시작 도시 X 설정
        queue.add(X);
        distance[X] = 0;

        // BFS 시작
        while (!queue.isEmpty()) {
            int currentCity = queue.poll();

            for (int nextCity : graph.get(currentCity)) {
                if (distance[nextCity] == -1) {
                    distance[nextCity] = distance[currentCity] + 1;
                    queue.add(nextCity);
                }
            }
        }

        // 결과 출력
        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }
}