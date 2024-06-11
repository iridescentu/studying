import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 백준 13975: 파일 합치기 3
        // ---------------------------------------------------------------------------
        // * 파일 크기를 합치는 데 필요한 최소 비용 구해야 함
        // * 두 파일을 합칠 때 비용은 두 파일의 크기의 합임
        // * Min-Heap을 사용해 파일 크기를 오름차순으로 정렬하고 가장 작은 두 파일을 합쳐 최소 비용 계산
        // ---------------------------------------------------------------------------

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수 입력
        int T = Integer.parseInt(br.readLine());

        // 결과를 한 번에 출력하기 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // 각 테스트 케이스를 처리
        for (int i = 0; i < T; i++) {
            // 각 테스트 케이스별 장의 수 입력
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();

            // 파일 크기를 최소 힙에 추가
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long totalCost = 0;

            // 파일을 하나로 합칠 때까지 반복
            while (pq.size() > 1) {
                // 가장 작은 두 파일을 꺼내서 합친다
                long first = pq.poll();
                long second = pq.poll();
                long cost = first + second;

                // 합친 파일을 다시 최소 힙에 추가
                pq.add(cost);

                // 누적 비용 계산
                totalCost += cost;
            }

            // 결과 저장
            sb.append(totalCost).append("\n");
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}