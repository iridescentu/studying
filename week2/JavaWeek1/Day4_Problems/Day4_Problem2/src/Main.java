import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // * 백준 11721: 열 개씩 끊어 출력하기
        // --------------------------------
        Scanner sc = new Scanner(System.in);

        // 사용자로부터 문자열 입력 받기
        String input = sc.nextLine(); // 사용자 입력을 한 줄 읽음
        int length = input.length();

        // 10글자씩 잘라서 출력
        for (int i = 0; i < length; i += 10) {
            // i 위치에서 시작하여 10글자 뒤 또는 문자열의 끝 중 더 짧은 위치까지의 부분 문자열을 출력
            int end = Math.min(i + 10, length); // 마지막 부분 처리를 위해 Math.min 사용
            System.out.println(input.substring(i, end)); // 부분 문자열 출력
        }

        sc.close(); // 스캐너 사용 종료
    }
}