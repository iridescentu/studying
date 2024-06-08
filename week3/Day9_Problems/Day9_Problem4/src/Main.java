import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 11899: 괄호 끼워넣기
        // ------------------------------------------------------------------------------
        // * 주어진 괄호열에서 올바른 괄호열로 만들기 위해 필요한 최소한의 괄호 개수를 찾아야 함
        // * 올바른 괄호열이 되기 위해서는 모든 시점에서 여는 괄호의 수가 닫는 괄호의 수보다 "많거나 같아"야 함
        // * 주어진 괄호열을 순차적으로 탐색하면서 여는 괄호와 닫는 괄호의 수를 계산해야 함
        // * 닫는 괄호가 여는 괄호보다 많아지는 시점에서는 앞쪽에 여는 괄호를 추가해야 함
        // * 모든 괄호를 탐색한 뒤에 여는 괄호가 더 많은 경우, 그 차이만큼 뒤에 닫는 괄호를 추가해야 함
        // * 앞에 추가해야 할 여는 괄호의 수와 뒤에 추가해야 할 닫는 괄호의 수를 합친 값이 정답이 됨
        // ------------------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        System.out.println(minAddToValid(s));
    }

    public static int minAddToValid(String s) {
        // 필요한 여는 괄호와 닫는 괄호의 수를 저장할 변수 선언
        int openNeeded = 0, closeNeeded = 0;

        for (char c : s.toCharArray()) {
            // 현재 문자가 닫는 괄호인 경우
            if (c == ')') {
                // 여는 괄호가 필요하지 않을 때에는 닫는 괄호가 하나 더 필요
                if (openNeeded == 0) closeNeeded++;
                // 여는 괄호가 필요하다면 여는 괄호 하나 사용
                else openNeeded--;
            }
            // 현재 문자가 여는 괄호일 경우에는 여는 괄호 하나 더 필요
            else openNeeded++;
        }

        // 앞에 추가해야 할 여는 괄호의 수와 뒤에 추가해야 할 닫는 괄호의 수를 합친 값으로 반환
        return openNeeded + closeNeeded;
    }
}