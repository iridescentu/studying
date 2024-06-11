import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1021: 회전하는 큐
        // ----------------------------------------------------------------------
        // * 큐에서 원하는 위치의 원소를 뽑아내기 위해 최소한의 이동 연산(왼쪽/오른쪽)을 사용해야 함
        // * 큐는 양방향 순환 큐로 왼쪽으로 이동시키면 첫 번째 원소가 마지막으로 이동, 오른쪽으로
        //   이동시키면 마지막 원소가 첫 번째로 이동
        // ----------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt(); // 큐의 크기
        int M = sc.nextInt(); // 뽑아낼 원소의 개수
        List<Integer> positions = new ArrayList<>(); // 뽑아낼 원소의 위치 저장 리스트

        for (int i = 0; i < M; i++) {
            positions.add(sc.nextInt());
        }

        // 큐 초기화
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 결과를 저장할 변수
        int totalMoves = 0;

        // 각 원소를 뽑아내는 과정을 반복
        for (int pos : positions) {
            int index = queue.indexOf(pos); // 현재 뽑아낼 원소의 인덱스

            // 왼쪽으로 이동하는 경우와 오른쪽으로 이동하는 경우 중 최소 이동 횟수를 선택
            int leftMoves = index;
            int rightMoves = queue.size() - index;

            totalMoves += Math.min(leftMoves, rightMoves);

            // 최소 이동 횟수만큼 이동 후, 원소를 뽑아냄
            if (leftMoves <= rightMoves) {
                for (int i = 0; i < leftMoves; i++) {
                    queue.addLast(queue.removeFirst());
                }
            } else {
                for (int i = 0; i < rightMoves; i++) {
                    queue.addFirst(queue.removeLast());
                }
            }

            // 원소를 뽑아낸다
            queue.removeFirst();
        }

        // 결과 출력
        System.out.println(totalMoves);
    }
}