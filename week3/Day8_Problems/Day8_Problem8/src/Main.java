import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 10815: 숫자 카드
        // ---------------------------------------------------------------
        // * 상근이가 가진 숫자 카드 목록 & 찾으려는 숫자 목록이 주어짐
        // * 숫자 카드 목록에서 각 숫자가 존재하는지 확인해야 함
        // * 효율적인 검색을 위해 해시셋 사용
        // * 해시셋에 상근이가 가진 숫자 카드들을 저장, 찾으려는 숫자가 해시셋이 있는지 확인
        // ---------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 상근이가 가진 숫자 카드의 개수 N 입력
        int N = sc.nextInt();

        // 상근이가 가진 숫자 카드를 저장할 해시셋 생성
        HashSet<Integer> cardSet = new HashSet<>();

        // 상근이의 숫자 카드 입력 받아 해시셋에 저장
        for (int i = 0; i < N; i++) {
            cardSet.add(sc.nextInt());
        }

        // 찾고자 하는 숫자의 개수 M 입력
        int M = sc.nextInt();

        // M개의 숫자를 입력 받아 각각이 해시셋에 있는지 확인하고 결과 저장
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            if (cardSet.contains(num)) {
                result.append("1 ");
            } else {
                result.append("0 ");
            }
        }

        // 결과 출력
        System.out.println(result.toString().trim());
    }
}