//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        // 백준 27160: 할리갈리
//        // -------------------------------------------------------
//        // * 주어진 카드 중 특정 과일의 총 개수가 정확히 5개인지 판별해 종을 쳐야 하는지를 결정해야 한다.
//        // * 따입력으로 주어진 카드 정보를 바탕으로 각 과일의 총 개수를 계산한다.
//        // * HashMap을 사용해 각 과일의 이름을 키로, 해당 과일의 총 개수를 값으로 저장한다.
//        // * 과일의 개수가 5개인 경우에만 종을 치는 것이 올바른 판단이기 때문에 HashMap에 저장된 값 중 값이 5인 경우를 찾아야 한다.
//        // * HashMap에서 과일의 개수를 가져오기 위해 getOrDefault 메소드를 사용해 해당 과일이 이미 있으면 그 값을 가져오고, 없으면 0을 반환하도록 한다.
//        // * 이를 통해 모든 카드 정보를 처리 후, HashMap의 값들을 순회하며 값이 5인 경우가 있는지 확인한다.
//        // * 값이 5인 과일이 있으면 종을 칠 수 있으니 canRingBell을 true로 설정하고, 그렇지 않으면 false로 유지한다.
//        // * 마지막으로 canRingBell의 값에 따라 YES 또는 NO를 출력한다.
//        // -------------------------------------------------------
//
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt(); // 카드의 수 N을 입력 받음
//        sc.nextLine(); // 줄바꿈 문자 소비
//
//        Map<String, Integer> fruitCount = new HashMap<>();
//
//        boolean canRingBell = false; // 종을 칠 수 있는지 여부를 확인하는 변수
//
//        for (int i = 0; i < N; i++) {
//            String fruit = sc.next(); // 과일 이름 입력 받기
//            int count = sc.nextInt(); // 과일 개수 입력 받기
//            sc.nextLine(); // 줄바꿈 문자 소비
//
//            int newCount = fruitCount.getOrDefault(fruit, 0) + count;
//            fruitCount.put(fruit, newCount);
//        }
//
//        for (int count : fruitCount.values()) {
//            // 한 종류의 과일이 정확히 5개인 경우 종을 칠 수 있음
//            if (count == 5) {
//                canRingBell = true;
//                break;
//            }
//        }
//
//        if (canRingBell) {
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }
//    }
//}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 카드의 수 N을 입력 받음
        sc.nextLine(); // 줄바꿈 문자 소비

        Map<String, Integer> fruitCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String fruit = sc.next(); // 과일 이름 입력 받기
            int count = sc.nextInt(); // 과일 개수 입력 받기
            sc.nextLine(); // 줄바꿈 문자 소비

            // 과일의 개수를 업데이트
            fruitCount.put(fruit, fruitCount.getOrDefault(fruit, 0) + count);
        }

        // 한 종류의 과일이 정확히 5개인 경우를 확인
        boolean canRingBell = fruitCount.values().stream().anyMatch(count -> count == 5);

        // 결과 출력
        System.out.println(canRingBell ? "YES" : "NO");
    }
}