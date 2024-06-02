import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 10798: 세로 읽기
        // * 2차원 배열 형태로 입력된 문자들을 세로로 읽어야 함
        // * 각 줄의 길이는 다를 수 있으니 각 줄을 읽으며 끝에 도달했는지 확인해야 함
        // * 가장 긴 줄의 길이를 알아내고, 이를 기준으로 모든 줄을 세로로 읽음
        // * 각 줄의 같은 인덱스를 차례대로 읽으면서 해당 위치에 문자가 없으면 넘어감
        // * StringBuilder를 사용해 세로로 읽은 문자들을 순서대로 추가함

        Scanner sc = new Scanner(System.in);

        // 5개의 문자열을 저장할 배열
        String[] words = new String[5];

        // 가장 긴 문자열의 길이를 저장할 변수
        int maxLength = 0;

        // 입력받은 문자열을 배열에 저장하고, 가장 긴 길이를 찾는다.
        for (int i = 0; i < 5; i++) {
            words[i] = sc.nextLine();
            maxLength = Math.max(maxLength, words[i].length());
        }

        // StringBuilder를 사용하여 최종 결과를 저장
        StringBuilder result = new StringBuilder();

        // 0번째 인덱스부터 가장 긴 문자열의 길이까지 세로로 문자를 읽는다.
        for (int i = 0; i < maxLength; i++) {
            // 각 줄을 확인
            for (int j = 0; j < 5; j++) {
                // 현재 줄의 길이가 i보다 크면 문자가 존재한다는 의미이므로 결과에 추가
                if (words[j].length() > i) {
                    result.append(words[j].charAt(i));
                }
            }
        }

        // 결과 출력
        System.out.println(result.toString());
    }
}