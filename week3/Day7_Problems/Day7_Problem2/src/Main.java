import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 27160: 할리갈리
        // -----------------------------------------------------------------------------------------------------
        // * 카드에 그려진 과일의 종류와 개수를 분석해 한 종류의 과일이 "정확히" 5 개 있는지 확인해야 한다.
        // * HashMap을 사용해 각 과일 종류별로 총 개수를 저장한다. 그리고 과일의 개수를 업데이트할 때마다 5 개인지 확인해야 한다.
        // * Stream API를 사용해 HashMap의 values()를 스트리밍하고, anyMatch() 메소드를 통해 조건에 맞는 값이 있는지 확인해야 한다.
        // * 이 경우, 정확히 5개인 과일이 있다면 "YES"를, 아니라면 "NO"를 출력해야 한다.
        // -----------------------------------------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 카드의 수 N을 입력 받음
        sc.nextLine();

        Map<String, Integer> fruitCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String fruit = sc.next(); // 과일 이름 입력 받기
            int count = sc.nextInt(); // 과일 개수 입력 받기
            sc.nextLine();

            // 과일의 개수를 업데이트하고, 이미 존재하는 과일이라면 기존 수량에 추가
            fruitCount.put(fruit, fruitCount.getOrDefault(fruit, 0) + count);
        }

        // 한 종류의 과일이 정확히 5개인 경우를 확인
        boolean canRingBell = fruitCount.values().stream().anyMatch(count -> count == 5);

        // 결과 출력. 조건에 맞는 경우 "YES", 아니면 "NO"
        System.out.println(canRingBell ? "YES" : "NO");
    }
}