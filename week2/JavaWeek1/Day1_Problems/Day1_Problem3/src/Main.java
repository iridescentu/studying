import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2675: 문자열 반복
        // 1. 입력받기
        //     - 첫 줄에 테스트 케이스의 개수 T를 입력받는다
        //     - 이후 각 테스트 케이스마다 반복 횟수 R과 문자열 S를 입력받는다
        // 2. 문자열 반환
        //     - 각 테스트 케이스에 문자열 S의 각 문자를 R번 반복해 새로운 문자열 P를 만든다
        // 3. 출력하기
        //     - 각 테스트 케이스에 대해 생성된 문자열 P를 출력한다
        // --------------------------------------------------------------

        // 입력을 받기 위해 Scanner 객체를 생성한다
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스의 개수를 입력받는다
        int T = sc.nextInt();

        // 각 테스트 케이스를 처리하기 위한 반복문
        for (int i = 0; i < T; i++) {
            // 반복 횟수 R을 입력받는다
            int R = sc.nextInt();
            // 문자열 S를 입력받는다
            String S = sc.next();

            // 결과 문자열을 저장할 변수
            String P = "";

            // 문자열 S의 각 문자를 반복 처리하기 위한 반복문
            for (int j = 0; j < S.length(); j++) {
                // 현재 문자를 R번 반복하여 P에 추가한다.
                for (int k = 0; k < R; k++) {
                    P += S.charAt(j);
                }
            }

            // 완성된 문자열 P를 출력한다
            System.out.println(P);
        }

    }
}