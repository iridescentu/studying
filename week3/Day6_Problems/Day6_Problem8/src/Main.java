import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 백준 2346: 풍선 터뜨리기
        // --------------------------------------------------------------------
        // * 풍선의 순서를 유지하고 터진 풍선을 제거하기 위해 리스트 사용
        // * 터뜨릴 풍선을 선택하기 위해 큐를 활용
        // * 리스트의 양 끝을 넘어가는 이동을 처리하기 위해 원형 리스트 개념 적용
        // * 모든 풍선이 터질 때까지 반복문 사용, 각 풍선의 이동 방향을 결정하기 위해 조건문 사용
        // --------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 1. 입력 받기 및 초기화
        // N 입력 받기 (풍선의 개수)
        int N = sc.nextInt();
        // 각 풍선의 값을 저장할 배열
        int[] balloons = new int[N];
        // 풍선의 값을 차례로 입력받기
        for (int i = 0; i < N; i++) {
            balloons[i] = sc.nextInt();
        }

        // 2. 첫 번째 풍선 터뜨리기
        // 터진 풍선의 순서를 저장할 리스트
        List<Integer> result = new ArrayList<>();
        // 풍선의 인덱스를 저장할 LinkedList (덱으로 사용)
        LinkedList<Integer> deque = new LinkedList<>();
        // 인덱스를 1부터 N까지 덱에 추가
        for (int i = 0; i < N; i++) {
            deque.add(i + 1);
        }

        // 3. 반복문을 통한 풍선 터뜨리기
        // 현재 터뜨릴 풍선의 인덱스
        int index = 0;
        while (!deque.isEmpty()) {
            // 현재 인덱스의 풍선을 터뜨리고 결과 리스트에 추가
            result.add(deque.remove(index));
            // 덱이 비어있으면 종료
            if (deque.isEmpty()) break;

            // 이동할 거리
            int move = balloons[result.get(result.size() - 1) - 1];
            if (move > 0) {
                // 양수 이동
                index = (index + move - 1) % deque.size();
            } else {
                // 음수 이동
                index = (index + move) % deque.size();
                // 음수 인덱스 조정
                if (index < 0) index += deque.size();
            }
        }

        // 4. 결과 출력
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}