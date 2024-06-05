import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 17608: 막대기
        Scanner sc = new Scanner(System.in);

        // 막대기 개수
        int N = sc.nextInt();
        int[] heights = new int[N];

        // 막대기 높이
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }

        // 보이는 막대기 개수를 저장할 변수
        int visible = 0;

        // 현재까지 가장 높은 막대기 높이
        int maxHeight = 0;

        // 오른쪽 -> 왼쪽으로
        for (int i = N - 1; i >= 0; i--) {
            // 현재 막대기가 이전까지 본 가장 높은 막대기보다 높다면
            if (heights[i] > maxHeight) {
                visible++;
                maxHeight = heights[i]; // 최고 높이 갱신
            }
        }

        System.out.println(visible);
    }
}