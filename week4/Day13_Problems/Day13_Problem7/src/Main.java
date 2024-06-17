import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1931: 회의실 배정
        // ---------------------------------------------------------------------
        // * 그리디 알고리즘 사용
        // * 회의 종료 시간을 기준으로 정렬하고 가능한 많은 회의를 선택
        // * 회의가 끝나는 시간에 가장 빨리 끝나는 회의를 선택하면 이후의 회의들을 더 많이 선택 가능
        // * 회의 종료 시간을 기준으로 오름차순 정렬하고 회의가 끝나는 시간을 갱신하며 회의 개수 세기
        // ---------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 회의의 수 N
        int n = sc.nextInt();

        // 회의 정보를 저장할 배열을 선언
        int[][] meetings = new int[n][2];

        // 각 회의의 시작 시간과 종료 시간을 입력받음
        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt(); // 시작 시간
            meetings[i][1] = sc.nextInt(); // 종료 시간
        }

        // 회의를 종료 시간 기준으로 정렬
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 종료 시간이 같으면 시작 시간을 기준으로 정렬
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });

        // 최대 사용할 수 있는 회의의 개수를 세기 위한 변수
        int count = 0;
        // 마지막으로 선택한 회의의 종료 시간을 저장할 변수
        int endTime = 0;

        // 정렬된 회의 배열을 순회하며 회의를 선택
        for (int i = 0; i < n; i++) {
            // 현재 회의의 시작 시간이 마지막으로 선택한 회의의 종료 시간 이후라면
            if (meetings[i][0] >= endTime) {
                // 현재 회의를 선택하고
                count++;
                // 마지막으로 선택한 회의의 종료 시간을 갱신
                endTime = meetings[i][1];
            }
        }

        // 최대 사용할 수 있는 회의의 개수를 출력
        System.out.println(count);
    }
}
