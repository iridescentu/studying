import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 12605: 단어 순서 뒤집기

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= N; i++) {
            String line = sc.nextLine();

            // 단어들을 스페이스 기준으로 분리
            String[] words = line.split(" ");

            // 단어들을 반대로 뒤집기 위해 StringBuilder 사용
            StringBuilder reverse = new StringBuilder();

            // 단어들을 뒤에서부터 앞으로 추가
            for (int j = words.length - 1; j>= 0; j--) {
                reverse.append(words[j]);
                if (j != 0) {
                    reverse.append(" ");
                }
            }

            System.out.println("Case #" + i + ": " + reverse.toString());
        }
        sc.close();
    }
}