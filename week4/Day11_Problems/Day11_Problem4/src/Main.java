import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 10419: 지각
        // ----------------------------------------------------------------------
        // * 수업 시간 d가 주어졌을 때 교수님이 지각할 수 있는 최대 시간 t를 구해야 함
        // * 지각 시간 t와 수업을 일찍 마치는 시간 s 사이의 관계는 s = t^2
        // * 교수님이 지각한 시간 t와 일찍 마치는 시간 s의 합이 수업 시간 d를 넘지 않아야 함
        //    - t + t^2 <= d
        // * 주어진 수업 시간 d에 대해 가능한 최대 t를 찾기 위해 t를 0부터 시작해 하나씩 증가시키며
        //   조건 t + t^2 <=d를 만족하는지 확인해야 함
        // * 조건을 만족하지 않는 순간 이전 값이 최대 지각 시간 t가 된다
        // ----------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        // T 개의 수업 시간을 저장할 배열
        int[] d = new int[T];
        // T 개의 수업 시간을 배열에 저장
        for (int i = 0; i < T; i++) {
            d[i] = sc.nextInt();
        }

        // 각 수업 시간에 대해 최대 지각 시간을 계산해 출력
        for (int i = 0; i < T; i++) {
            System.out.println(maxT(d[i]));
        }
    }

    // 주어진 수업 시간 d에 대해 최대 지각 시간 t를 반환하는 함수
    // t + t^2 <= d 조건을 만족하는 최대 t 찾기
    public static int maxT(int d) {
        int t = 0;
        // t + t^2 <= d 조건 만족하는 최대 t 찾기
        while (t + t * t <= d) {
            t++;
        }
        // 마지막 t는 조건을 만족하지 않으니 t-1 반환
        return t - 1;
    }
}