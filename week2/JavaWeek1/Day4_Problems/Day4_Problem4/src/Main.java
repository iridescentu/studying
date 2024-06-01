import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 28432: 끝말잇기
        // ---------------------------------------------
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 끝말잇기 기록의 길이
        sc.nextLine(); // 개행 문자 제거

        ArrayList<String> records = new ArrayList<>();

        // 끝말잇기 기록 입력 받기
        for (int i = 0; i < N; i++) {
            records.add(sc.nextLine());
        }

        int M = sc.nextInt(); // 후보 단어의 개수
        sc.nextLine(); // 개행 문자 제거

        ArrayList<String> candidates = new ArrayList<>();

        // 후보 단어 입력 받기
        for (int i = 0; i < M; i++) {
            candidates.add(sc.nextLine());
        }

        // "?" 위치 찾기
        int questionMarkIndex = records.indexOf("?");

        // 올바른 단어 찾기
        for (String candidate : candidates) {
            if (isValidWord(candidate, records, questionMarkIndex)) {
                System.out.println(candidate);
                break;
            }
        }

        sc.close();
    }

    // 올바른 단어인지 확인하는 메소드
    public static boolean isValidWord(String word, ArrayList<String> records, int questionMarkIndex) {
        // 이전 단어의 마지막 글자와 현재 단어의 첫 글자 비교
        if (questionMarkIndex > 0 && records.get(questionMarkIndex - 1).charAt(records.get(questionMarkIndex - 1).length() - 1) != word.charAt(0))
            return false;

        // 다음 단어의 첫 글자와 현재 단어의 마지막 글자 비교
        if (questionMarkIndex < records.size() - 1 && records.get(questionMarkIndex + 1).charAt(0) != word.charAt(word.length() - 1))
            return false;

        // 단어 중복 확인
        for (int i = 0; i < records.size(); i++) {
            if (i != questionMarkIndex && records.get(i).equals(word))
                return false;
        }

        return true; // 모든 조건을 만족하면 true 반환
    }
}