import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 11286: 절댓값 힙
        // --------------------------------------------------
        // * PriorityQueue 사용해 절댓값 힙 구현하기
        // * 입력된 연산의 개수 N 읽기
        // * N개의 연산을 처리할 때:
        //   - x가 0이 아니면 힙에 추가
        //   - x가 0이면 힙에서 절댓값이 가장 작은 값을 출력하고 제거
        // --------------------------------------------------

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 연산의 개수를 입력받음

        // 절댓값을 기준으로 정렬하되, 절댓값이 같을 경우 실제 값이 작은 것을 우선함
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if (abs1 == abs2) {
                    return o1 - o2; // 절댓값이 같으면 실제 값을 비교
                }
                return abs1 - abs2; // 절댓값을 기준으로 비교
            }
        });

        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt(); // 각 연산을 입력받음
            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append('\n'); // 배열이 비어 있으면 0을 출력
                } else {
                    sb.append(pq.poll()).append('\n'); // 배열에서 절댓값이 가장 작은 값을 출력하고 제거
                }
            } else {
                pq.add(x); // 배열에 x를 추가
            }
        }

        System.out.print(sb.toString()); // 결과 출력
    }
}