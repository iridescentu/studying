import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 15829: Hashing
        // --------------------------------------------------------------------------
        // * 문자열의 각 문자에 해당하는 숫자를 특정 방식으로 변환해 해시 값을 계산해야 함
        // * 각 문자는 a부터 z까지 알파벳 소문자로만 이루어져 있고, a는 1, b는 2...... z는 26에 해당
        // --------------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 문자열 길이 입력
        int L = sc.nextInt();
        // 문자열 입력
        String str = sc.next();

        sc.close();

        // 해시 값 계산
        long hashValue = calculateHash(L, str);
        // 결과 출력
        System.out.println(hashValue);
    }

    // 해시 값을 계산하는 함수
    public static long calculateHash(int L, String str) {
        final int r = 31; // r 값
        final int M = 1234567891; // M 값

        long hashValue = 0; // 최종 해시 값
        long power = 1; // r^i 값을 저장할 변수

        for (int i = 0; i < L; i++) {
            // 문자 'a'는 1, 'b'는 2, ..., 'z'는 26에 대응
            int charValue = str.charAt(i) - 'a' + 1;
            // 해시 값 계산
            hashValue = (hashValue + charValue * power) % M;
            // 다음 r^i 값을 위해 r을 곱해줌
            power = (power * r) % M;
        }

        return hashValue;
    }
}