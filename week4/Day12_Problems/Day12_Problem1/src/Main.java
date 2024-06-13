import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2851: 슈퍼 마리오
        // 시간 복잡도: O(1)
        // ---------------------------------------------------------------
        // * 10 개의 버섯 점수가 주어지며 버섯을 처음부터 순서대로 먹고, 중간에 멈출 수 있음
        // * 마리오가 먹은 점수의 합이 100에 가장 가까운 값을 출력해야 함
        // * 100에 가까운 값이 두 개라면 더 큰 값을 선택
        // * 버섯의 점수를 순서대로 합하면서 100에 가장 가까운 점수를 찾아야 함
        // * 누적합을 계산하며 100에 가장 가까운 점수를 비교하고 갱신해야 함
        // * 100을 넘을 때/100을 넘지 않을 때를 구분해 더 가까운 값을 선택해야 함
        // ---------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 버섯 점수 저장할 배열
        int[] mushrooms = new int[10];

        for (int i = 0; i < 10; i++) {
            mushrooms[i] = sc.nextInt();
        }

        // 누적합 변수 초기화
        int sum = 0;

        // 100에 가장 가까운 점수를 저장할 변수 초기화
        int closest = 0;

        // 버섯 점수를 순서대로 누적하고 100에 가장 가까운 값 찾기
        for (int i = 0; i < 10; i++) {
            sum += mushrooms[i];
            // 현재 누적합이 100에 더 가까운지 체크
            if (Math.abs(100 - sum) <= Math.abs(100 - closest)) {
                closest = sum; // 더 가까운 값으로 갱신
            }
        }

        System.out.println(closest);

        sc.close();
    }
}