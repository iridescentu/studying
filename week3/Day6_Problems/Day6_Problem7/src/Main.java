// 백준 9012: 괄호
// -------------------------------------------------------------
// * 스택을 이용한 괄호 검사 문제
// * 여는 괄호 '('를 만나면 스택에 push, 닫는 괄호 ')'를 만나면 스택에서 pop
// * 스택을 이용해 여는 괄호와 닫는 괄호의 짝을 맞추는 방식으로 VPS 여부 판단
// * 모든 문자열을 검사하고 스택이 비어 있으면 올바른 괄호 문자열임
// -------------------------------------------------------------

import java.util.Scanner;
import java.util.Stack;

public class Main {
    // * 주어진 문자열이 VPS인지 확인하는 함수
    public static String isVPS(String ps) {
        // * 스택을 사용하여 여는 괄호와 닫는 괄호의 짝을 맞추는 방식으로 확인
        Stack<Character> stack = new Stack<>();
        for (char ch : ps.toCharArray()) {
            if (ch == '(') {
                stack.push(ch); // * 여는 괄호는 스택에 push
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return "NO"; // * 스택이 비어있으면 짝이 맞지 않음
                }
                stack.pop(); // * 닫는 괄호는 스택에서 pop
            }
        }
        return stack.isEmpty() ? "YES" : "NO"; // * 문자열을 다 확인한 후 스택이 비어 있으면 YES
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // * 첫 번째 줄에 테스트 케이스의 수 T 입력
        int T = scanner.nextInt();
        scanner.nextLine(); // * 개행 문자 제거

        // * 각 테스트 케이스에 대해
        for (int i = 0; i < T; i++) {
            String ps = scanner.nextLine(); // * 괄호 문자열 입력
            System.out.println(isVPS(ps)); // * VPS 여부 출력
        }

        scanner.close();
    }
}