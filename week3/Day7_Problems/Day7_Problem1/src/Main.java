import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 9933: 민균이의 비밀번호
        // --------------------------------------------------------------------------------------
        // * 주어진 단어 목록 중 어떤 단어와 그 단어를 뒤집은 단어가 "모두" 목록에 존재하는 경우, 그 단어가 비밀번호이다.
        //   비밀번호의 길이와 가운데 글자를 출력해야 한다.
        // * 모든 단어를 순회하면서, 각 단어를 뒤집어 해당 단어가 목록에 존재하는지 확인해야 한다.
        // * 단어와 뒤집은 단어가 모두 목록에 있으면, 그 단어 길이와 가운데 글자룰 출력한다.
        // * 필요한 개념: 문자열 뒤집기, 목록 순회, 문자열 길이와 가운데 글자 찾기.
        // * 핵심 코드:
        //      - 문자열 뒤집기: StringBuilder의 reverse() 메서드 사용
        //      - 목록 순회: for-each 루프 사용
        //      - 가운데 글자 찾기: 문자열 길이를 2로 나눈 몫을 인덱스로 사용
        // --------------------------------------------------------------------------------------
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.nextLine();
        }

        // 단어 목록 순회
        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString(); // 단어 뒤집기

            // 뒤집은 단어가 목록에 있는지 확인
            for (String password : words) {
                if (password.equals(reversed)) {
                    // 비밀번호: 길이와 가운데 글자 출력
                    System.out.println(word.length() + " " + word.charAt(word.length() / 2));
                    return;
                }
            }
        }
    }
}