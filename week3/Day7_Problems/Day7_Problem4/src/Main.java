import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1927: 최소 힙
        // --------------------------------------------------------
        // * PriorityQueu를 사용해 최소 힙 구현하기
        // * 조건 분기 처리하기:
        //    - 입력값 x가 0이 아닌 경우 PriorityQueue에 x를 추가.
        //    - x가 0인 경우, PriorityQueue에서 최소 값을 제거하고 출력.
        //    - 만약 PriorityQueue가 비어 있다면 0을 출력.
        // --------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();

            if (x == 0) {
                // x가 0일 때, 힙이 비어 있지 않다면 최소 값을 제거하고 출력
                if (!minHeap.isEmpty()) {
                    System.out.println(minHeap.poll());
                } else {
                    // 힙이 비어 있다면 0을 출력
                    System.out.println(0);
                }
            } else {
                    // x가 0이 아니라면 힙에 x를 추가
                    minHeap.add(x);
                }
            }

            sc.close();
    }
}