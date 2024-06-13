// 백준 1213: 팰린드롬 만들기
// 시간 복잡도:
// ------------------------------------------------------------------------------
// * 이 프로그램은 주어진 문자열을 팰린드롬으로 바꾸는 것이 목표
// * 팰린드롬을 만들기 위해서는 문자열에서 홀수 개의 문자가 1개 이하이어야 함
// * 문자열의 각 문자의 빈도를 계산하고, 홀수 개의 문자가 1개 이하인지 확인해야 함
// * 홀수 개의 문자가 1개 이하이면 팰린드롬을 만들 수 있음
// * 팰린드롬을 만들기 위해 알파벳 순서로 절반을 앞에 배치하고, 나머지 절반을 뒤에 배치해야 함
// * 홀수 개의 문자는 팰린드롬의 가운데에 배치함
// ------------------------------------------------------------------------------

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        sc.close();

        // 빈도 계산을 위한 TreeMap 사용 (알파벳 순서로 정렬됨)
        Map<Character, Integer> freq = new TreeMap<>();

        // 문자열의 각 문자의 빈도를 계산
        for (char c : name.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // 홀수 개의 문자의 개수를 세기 위한 변수와 홀수 개의 문자를 저장할 변수
        int oddCount = 0;
        char oddChar = 0;

        // 문자열을 팰린드롬으로 바꿀 수 있는지 확인
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddCount++;
                oddChar = entry.getKey();
            }
        }

        // 홀수 개의 문자가 1개 초과이면 팰린드롬을 만들 수 없음
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 팰린드롬의 앞부분과 뒷부분을 저장할 StringBuilder
        StringBuilder front = new StringBuilder();
        StringBuilder rear = new StringBuilder();

        // 각 문자를 반으로 나누어 앞부분과 뒷부분에 배치
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue() / 2;
            for (int i = 0; i < count; i++) {
                front.append(c);
                rear.insert(0, c); // 뒷부분은 역순으로 추가
            }
        }

        // 결과 문자열을 저장할 StringBuilder
        StringBuilder result = new StringBuilder();
        result.append(front);

        // 홀수 개의 문자가 있으면 가운데에 추가
        if (oddCount == 1) {
            result.append(oddChar);
        }

        // 뒷부분 추가
        result.append(rear);

        // 결과 출력
        System.out.println(result.toString());
    }
}