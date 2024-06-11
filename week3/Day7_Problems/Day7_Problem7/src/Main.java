import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 9375: 패션왕 신해빈
        // --------------------------------------------------------------
        // * 의상 조합을 통해 알몸이 아닌 상태로 며칠 동안 밖에 나갈 수 있는지 계산해야 함
        // * 각 종류의 의상은 하나만 입을 수 있고, 종류별로 의상이 여러 개 있을 수 있음
        // * 의상의 종류별로 입을 수 있는 경우의 수를 계산해야 함
        // --------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 수
        int testCaseCount = sc.nextInt();

        // 각 테스트 케이스에 대해 처리
        for (int t = 0; t < testCaseCount; t++) {
            // 의상의 수 입력 받기
            int n = sc.nextInt();

            // 의상 종류별로 의상 개수를 세기 위한 HashMap 생성
            HashMap<String, Integer> clothingMap = new HashMap<>();

            // 의상 정보 입력 받기
            for (int i = 0; i < n; i++) {
                String clothingName = sc.next(); // 의상 이름 (사용되지 않음)
                String clothingType = sc.next(); // 의상 종류

                // 의상 종류별로 개수 증가
                clothingMap.put(clothingType, clothingMap.getOrDefault(clothingType, 0) + 1);
            }

            // 조합 계산
            int combinations = 1;
            for (int count : clothingMap.values()) {
                combinations *= (count + 1); // 해당 종류의 의상 개수 + 1 (입지 않는 경우 포함)
            }

            // 알몸인 경우 제외
            combinations -= 1;

            // 결과 출력
            System.out.println(combinations);
        }

        sc.close();
    }
}