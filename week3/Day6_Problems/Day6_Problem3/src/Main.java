import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2153: 소수 단어
        // -------------------------------------------------------------
        // * 주어진 단어의 각 문자를 숫자로 변환해 그 합이 소수인지 판별해야 함
        // * 알파벳 소문자와 대문자를 숫자로 변환하는 방법?
        //      - 소문자 a는 1, b는 2...... z는 26으로 변환
        //      - 대문자 A는 27, B는 28...... Z는 52로 변환
        // * 변환된 숫자들의 합을 구하고 그 합이 소수인지 판별해야 함
        // * 소수 판별은 2부터 합의 제곱근까지 나누며 나눠떨어지는 수가 있는지 확인해야 함
        // -------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        int sum = 0;

        // 1. 각 문자를 숫자로 변환하고 합하기
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if ('a' <= c && c <= 'z') {
                // 소문자일 경우
                sum += c - 'a' + 1;
            } else {
                // 대문자일 경우
                sum += c - 'A' + 27;
            }
        }

        // 2. 합이 소수인지 판별
        if (isPrime(sum)) {
            System.out.println("It is a prime word.");
        } else {
            System.out.println("It is not a prime word.");
        }
    }

    // 소수인지 판별하는 메서드
    private static boolean isPrime(int number) {
        if (number == 1) return true; // 1도 소수로 간주
        if (number < 2) return false; // 2보다 작은 수 중에서 1을 제외하고는 소수가 아님
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // 나눠떨어지면 소수 X
            }
        }
        return true; // 나눠떨어지지 않으면 소수
    }
}