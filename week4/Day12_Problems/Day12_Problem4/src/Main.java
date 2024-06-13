// 백준 5568: 카드 놓기
// 시간 복잡도:
// ---------------------------------------------------------
// * 이 클래스는 사용자가 지정한 최대 값까지 소수를 구한다.
// * 알고리즘은 에라스토테네스 체다.
// * 2에서 시작하는 정수 배열을 대상으로 작업한다.
// * 처음으로 남아 있는 정수를 찾아 배수를 모두 제거한다.
// * 배열에 더 이상 배수가 없을 때까지 반복한다
// ---------------------------------------------------------

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 카드의 수 n과 선택할 카드의 수 k를 입력 받음
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        // 카드에 적힌 숫자를 저장할 배열
        String[] cards = new String[n];

        // n개의 카드에 적힌 숫자를 입력 받음
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextLine();
        }

        // 결과를 저장할 Set (중복 방지를 위해 Set 사용)
        Set<String> uniqueNumbers = new HashSet<>();

        // 모든 가능한 k개의 카드 조합을 만들어서 uniqueNumbers에 추가
        boolean[] visited = new boolean[n];
        generateNumbers(cards, "", k, visited, uniqueNumbers);

        // 결과 출력
        System.out.println(uniqueNumbers.size());
    }

    // k개의 카드를 선택하여 순서를 고려한 모든 정수 조합을 생성하는 재귀 함수
    public static void generateNumbers(String[] cards, String current, int k, boolean[] visited, Set<String> uniqueNumbers) {
        // 현재 선택한 카드가 k개가 되면 Set에 추가하고 재귀 종료
        if (k == 0) {
            uniqueNumbers.add(current);
            return;
        }

        // 각 카드를 하나씩 선택
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                generateNumbers(cards, current + cards[i], k - 1, visited, uniqueNumbers);
                visited[i] = false;
            }
        }
    }
}