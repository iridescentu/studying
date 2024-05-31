import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 코드1과 코드2의 실행 횟수를 저장할 변수
    static int code1Cnt = 0;
    static int code2Cnt = 0;

    // 동적 프로그래밍에서 사용할 배열
    static int[] f;

    public static void main(String[] args) throws IOException {
        // 백준 24416: 알고리즘 수업 - 피보나치 수 1
        // -----------------------------------------------------------
        // * 재귀 호출과 동적 프로그래밍을 사용해 피보나치 수를 계산하고,
        // * 각각의 코드 실행 횟수를 출력하는 문제이다.
        // * 재귀 호출의 경우 호출 횟수를 세기 위해 전역 변수를 사용한다.
        // * 동적 프로그래밍의 경우 반복문 내에서 실행 횟수를 세기 위해 전역 변수를 사용한다.
        // -----------------------------------------------------------

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 값을 받아 n에 저장
        int n = Integer.parseInt(br.readLine());
        br.close();

        // 배열 f를 크기 n으로 초기화
        f = new int[n + 1];

        // 재귀 함수로 피보나치 수 계산
        fib(n);

        // 동적 프로그래밍으로 피보나치 수 계산
        fibonacci(n);

        // 코드1과 코드2의 실행 횟수를 출력
        System.out.println(code1Cnt + " " + code2Cnt);
    }

    // 피보나치 수 재귀 호출 함수
    static int fib(int n) {
        // n이 1 또는 2일 때 코드1 실행
        if (n == 1 || n == 2) {
            code1Cnt++;  // 코드1 실행 횟수 증가
            return 1;
        } else {
            // 재귀 호출
            return fib(n - 1) + fib(n - 2);
        }
    }

    // 피보나치 수 동적 프로그래밍 함수
    static int fibonacci(int n) {
        // 초기 값 설정
        f[1] = 1;
        f[2] = 1;

        // 3부터 n까지 피보나치 수 계산
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            code2Cnt++;  // 코드2 실행 횟수 증가
        }

        // n번째 피보나치 수 반환
        return f[n];
    }
}
