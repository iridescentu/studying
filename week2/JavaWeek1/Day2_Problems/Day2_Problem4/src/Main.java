import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1157: 단어 공부
        // -------------------------------------------------------
        // * 주어진 단어를 모두 대문자로 변환하면 대소문자를 구분하지 않고 처리할 수 있음.
        // * 각 문자의 출현 횟수를 세기 위해 해시맵을 사용. 해시맵의 키는 알파벳이고, 값은 해당 알파벳의 출현 횟수.
        // * 모든 문자에 대해 출현 횟수를 계산하고, 가장 많이 출현한 알파벳을 찾는다. 이때, 출현 횟수가 같은 알파벳이 여러 개인지도 확인해야 한다.
        // * 가장 많이 출현한 알파벳이 하나만 있는 경우 그 알파벳을 대문자로 출력하고, 여러 개 있는 경우 "?"를 출력한다.
        // -------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toUpperCase(); // 1. 입력받은 문자열을 모두 대문자로 변환
        HashMap<Character, Integer> frequencyMap = new HashMap<>(); // 2. 각 문자의 출현 횟수를 저장할 해시맵 생성

        for (char ch : input.toCharArray()) { // 입력받은 문자열에 대해 반복
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1); // 해당 문자의 출현 횟수를 1 증가시킴
        }

        int maxFrequency = Collections.max(frequencyMap.values()); // 가장 많이 출현한 횟수를 찾음
        char mostFrequentChar = '?';
        int count = 0; // 가장 많이 출현한 문자가 여러 개인지 확인하기 위한 카운터

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) { // 가장 많이 출현한 횟수와 같은 문자를 찾음
                mostFrequentChar = entry.getKey();
                count++;
                if (count > 1) { // 가장 많이 출현한 문자가 여러 개라면
                    mostFrequentChar = '?';
                    break;
                }
            }
        }

        System.out.println(mostFrequentChar); // 결과 출력
    }
}