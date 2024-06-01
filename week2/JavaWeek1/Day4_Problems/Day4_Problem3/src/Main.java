import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2745: 진법 변환
        // -------------------------------------------------------------
        Scanner sc = new Scanner(System.in);
        // 사용자로부터 문자열 N과 진법 B를 입력받는다.
        String N = sc.next();
        int B = sc.nextInt();

        // 결과값을 저장할 변수를 0으로 초기화한다.
        long result = 0;

        // 입력받은 문자열 N의 길이만큼 반복하여 각 문자를 처리한다.
        for (int i = 0; i < N.length(); i++) {
            // 문자열의 각 문자를 차례대로 가져와서 10진법 수로 변환한다.
            // '0'부터 '9'는 직접 숫자로 변환하고, 'A'부터 'Z'는 10 이상의 수를 나타내므로
            // 'A'에서 '0'을 빼고 10을 더해준다. (예: 'A' -> 10, 'B' -> 11, ..., 'Z' -> 35)
            int num = 0;
            if ('0' <= N.charAt(i) && N.charAt(i) <= '9') {
                num = N.charAt(i) - '0';
            } else {
                num = 10 + (N.charAt(i) - 'A');
            }

            // 변환된 수에 진법의 거듭제곱을 곱한 값을 결과 변수에 더해준다.
            // 진법의 거듭제곱은 문자열의 끝에서부터 계산된다. (예: 가장 오른쪽 문자는 B^0, 그 다음은 B^1, ...)
            result += num * Math.pow(B, N.length() - 1 - i);
        }

        // 최종적으로 계산된 10진법 수를 출력한다.
        System.out.println(result);
        sc.close();
    }
}