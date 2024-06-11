import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1966: 프린터 큐
        // --------------------------------------------------------
        // * 특정 문서가 몇 번째로 인쇄되는지 알아내야 함
        // * 문서의 중요도를 확인하고 더 높은 중요도의 문서가 있으면 뒤로 보내야 함
        // * 큐 자료구조를 이용해 FIFO 방식으로 접근
        // --------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt(); // 테스트 케이스의 수 입력

        // 각 테스트 케이스 처리
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt(); // 문서의 개수
            int m = sc.nextInt(); // 궁금한 문서의 초기 위치

            Queue<int[]> queue = new LinkedList<>();
            // 문서들의 중요도 입력
            for (int i = 0; i < n; i++) {
                queue.add(new int[]{i, sc.nextInt()});
            }

            // 인쇄 순서를 추적할 변수
            int printOrder = 0;

            // 큐가 빌 때까지 반복
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                boolean isPrintable = true;

                // 현재 문서보다 높은 중요도를 가진 문서가 있는지 확인
                for (int[] q : queue) {
                    if (q[1] > current[1]) {
                        isPrintable = false;
                        break;
                    }
                }

                // 인쇄 가능한 경우
                if (isPrintable) {
                    printOrder++;
                    if (current[0] == m) {
                        System.out.println(printOrder);
                        break;
                    }
                } else {
                    queue.add(current); // 인쇄 불가한 경우 뒤로 보냄
                }
            }
        }
        sc.close();
    }
}