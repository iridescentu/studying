// 백준 13335: 트럭
// 시간 복잡도:
// ----------------------------------------------------------------------------------------
// * 다리 길이 w만큼 큐를 초기화해 트럭이 다리 위에서 이동하는 것을 시뮬레이션함
// * 매 시간마다 다리의 맨 앞부분에서 트럭을 제거, 새로운 트럭을 다리 위에 올릴 수 있는지 확인해야 함
// * 새로운 트럭을 올릴 수 있으면 현재 무게 갱신하고 큐에 추가함. 그렇지 않다면 0을 추가해 다리 길이 유지
// * 모든 트럭이 다리를 건널 때까지 위 과정 반복
// ----------------------------------------------------------------------------------------

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄 입력: 트럭의 수 n, 다리의 길이 w, 다리의 최대하중 L
        int n = sc.nextInt();
        int w = sc.nextInt();
        int L = sc.nextInt();

        // 두 번째 줄 입력: 각 트럭의 무게 배열
        int[] truckWeights = new int[n];
        for (int i = 0; i < n; i++) {
            truckWeights[i] = sc.nextInt();
        }

        // * 트럭이 다리를 건너는 최단 시간을 계산하는 메서드를 호출
        System.out.println(calculateMinTime(n, w, L, truckWeights));
    }

    // * 트럭이 다리를 건너는 최단 시간을 계산하는 메서드
    public static int calculateMinTime(int n, int w, int L, int[] truckWeights) {
        Queue<Integer> bridge = new LinkedList<>();
        int currentWeight = 0; // 현재 다리 위의 트럭 무게 합
        int time = 0; // 경과 시간
        int index = 0; // 현재 트럭의 인덱스

        // * 초기 다리 상태를 빈 상태로 초기화
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        // * 모든 트럭이 다리를 건널 때까지 반복
        while (index < n || currentWeight > 0) {
            // 1. 다리 위에서 트럭 이동: 다리의 맨 앞(가장 오래된 위치) 트럭을 제거
            currentWeight -= bridge.poll();

            // 2. 다음 트럭을 다리 위에 올릴 수 있는지 확인
            if (index < n && currentWeight + truckWeights[index] <= L) {
                // 2-1. 다음 트럭을 다리 위에 올림
                bridge.add(truckWeights[index]);
                currentWeight += truckWeights[index];
                index++;
            } else {
                // 2-2. 다음 트럭을 올릴 수 없으면 0을 추가하여 다리 길이를 유지
                bridge.add(0);
            }

            // 3. 시간 경과
            time++;
        }

        return time;
    }
}