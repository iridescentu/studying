import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 16466: 콘서트
        // --------------------------------------
        // 1. 팔린 티켓 번호 정렬하기
        // 2. 1부터 시작해 차례대로 팔린 티켓 번호들과 비교
        // 3. 팔린 티켓 번호 중 없는 가장 작은 번호 찾기
        // --------------------------------------

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 1차 티켓팅에서 팔린 티켓의 수
        int[] tickets = new int[N]; // 팔린 티켓 번호들을 저장할 배열

        for (int i = 0; i < N; i++) {
            tickets[i] = sc.nextInt(); // 팔린 티켓 번호 입력받기
        }

        Arrays.sort(tickets); // 팔린 티켓 번호들을 정렬

        int result = 1; // 결과값 초기화 (가장 작은 티켓 번호부터 시작하기 위해)

        for (int ticket : tickets) {
            // 현재 티켓 번호가 결과값과 같다면 결과값을 1 증가시킴
            if (ticket == result) {
                result++;
            } else if (ticket > result) {
                // 현재 티켓 번호가 결과값보다 크다면 더 이상 확인할 필요 X
                break;
            }
        }

        System.out.println(result); // 가장 작은 번호 출력
    }
}