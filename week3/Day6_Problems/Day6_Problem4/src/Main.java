import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 7567: 그릇
        // -------------------------------------------------------
        // * 괄호 문자열을 읽어 그릇의 최종 높이를 계산해야 함
        // * 그릇은 ( 또는 )로 표현
        // * '('는 바로 놓인 상태의 그릇, ')'는 거꾸로 놓인 상태의 그릇을 의미
        // * 처음 그릇의 높이는 10cm고, 같은 방향의 그릇이 포개지면 5cm씩 증가
        // * 다른 방향의 그릇이 포개지면 10cm 증가
        // -------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine(); // 사용자로부터 괄호 문자 입력받기

        int totalHeight = calHeight(input); // 계산된 높이 반환하는 메서드 호출

        System.out.println(totalHeight);
    }

    public static int calHeight(String bowls) {
        int height = 10; // 첫 번째 그릇의 높이 초기화

        for (int i = 1; i < bowls.length(); i++) {
            // 현재 그릇과 이전 그릇의 방향이 같은 경우
            if (bowls.charAt(i) == bowls.charAt(i - 1)) {
                height += 5; // 높이 5cm 증가
            } else {
                height += 10; // 다른 경우 높이를 10cm 증가
            }
        }

        return height;
    }
}