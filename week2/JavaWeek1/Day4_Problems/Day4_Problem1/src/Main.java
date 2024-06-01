import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // * 백준 2902: KMP는 왜 KMP일까?
        // ---------------------------------------
        Scanner sc = new Scanner(System.in);

        // 사용자로부터 입력받은 문자열
        String input = sc.nextLine();

        // 결과를 저장할 StringBuilder 초기화
        StringBuilder shortForm = new StringBuilder();

        // 첫 번째 글자는 항상 대문자이므로 초기 결과에 추가
        shortForm.append(input.charAt(0));

        // 문자열을 순회하면서 대문자 찾기
        for (int i = 1; i < input.length(); i++) {
            // 현재 문자가 '-'인 경우, 다음 문자는 항상 대문자임
            if (input.charAt(i) == '-') {
                // 다음 문자를 결과에 추가
                shortForm.append(input.charAt(i + 1));
            }
        }

        // 결과 출력
        System.out.println(shortForm.toString());
    }
}