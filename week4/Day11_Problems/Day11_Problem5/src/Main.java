import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1251: 단어 나누기
        // -----------------------------------------------------------------------
        // * 주어진 단어를 세 부분으로 나누기 위해 두 개의 인덱스를 사용해 모든 가능한 조합 생성해야 함
        // * 각 조합에서 세 부분을 뒤집고 합침
        // * 합친 단어들 중 사전순으로 가장 앞에 있는 단어를 찾아야 함
        // -----------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        String word = sc.next(); // 단어 입력 받기
        sc.close();

        String result = null; // 결과 단어 초기화 (안 하면 틀렸다고 나옴)

        // 단어를 세 부분으로 나눌 수 있는 모든 조합을 생성
        for (int i = 1; i < word.length() - 1; i++) { // 첫 번째 나누는 위치
            for (int j = i + 1; j < word.length(); j++) { // 두 번째 나누는 위치
                // 세 부분으로 나누기
                String part1 = word.substring(0, i);
                String part2 = word.substring(i, j);
                String part3 = word.substring(j);

                // 각 부분을 뒤집기
                String reversedPart1 = new StringBuilder(part1).reverse().toString();
                String reversedPart2 = new StringBuilder(part2).reverse().toString();
                String reversedPart3 = new StringBuilder(part3).reverse().toString();

                // 뒤집은 부분들을 합치기
                String combined = reversedPart1 + reversedPart2 + reversedPart3;

                // 현재까지의 결과와 비교하여 사전순으로 더 앞서는 단어를 선택
                if (result == null || combined.compareTo(result) < 0) {
                    result = combined;
                }
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}