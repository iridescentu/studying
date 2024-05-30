//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        // 백준 2908: 상수
//        // -------------------------------------------------------
//        // 1. 문제 이해:
//        // * 두 세 자리 수가 주어지고, 상수는 이 수를 거꾸로 읽는다.
//        // * 두 수를 거꾸로 읽고, 더 큰 수를 출력한다.
//        // 2. 접근 방법:
//        // * 입력받은 두 수 A와 B를 문자열로 취급한다.
//        // * 문자열을 뒤집는다.
//        // * 뒤집은 문자열을 정수로 반환한다.
//        // * 두 정수를 비교하여 더 큰 수를 출력한다.
//        // -------------------------------------------------------
//
//        Scanner sc = new Scanner(System.in);
//
//        // 첫 번째 세 자리 수를 입력받는다.
//        String inputA = sc.next();
//        // 두 번째 세 자리 수를 입력받는다.
//        String inputB = sc.next();
//
//        // 입력받은 문자열을 뒤집고 정수로 변환하는 함수 호출
//        int reversedA = reverseAndConvert(inputA);
//        int reversedB = reverseAndConvert(inputB);
//
//        // 두 수 중 더 큰 수를 출력한다.
//        System.out.println(Math.max(reversedA, reversedB));
//    }
//
//    // 문자열을 뒤집고 정수로 변환한다.
//    public static int reverseAndConvert(String number) {
//        // 1. 문자열을 뒤집는다.
//        String reversedString = new StringBuilder(number).reverse().toString();
//        // 2. 뒤집힌 문자열을 정수로 변환하여 반환한다.
//        return Integer.parseInt(reversedString);
//    }
//}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(" "); // 1. 두 수를 문자열 배열로 입력받음

        int reversedFirst = Integer.parseInt(new StringBuilder(numbers[0]).reverse().toString()); // 2. 첫 번째 수를 뒤집어 정수로 변환
        int reversedSecond = Integer.parseInt(new StringBuilder(numbers[1]).reverse().toString()); // 3. 두 번째 수를 뒤집어 정수로 변환

        System.out.println(Math.max(reversedFirst, reversedSecond)); // 4. 거꾸로 읽은 두 수 중 더 큰 수를 출력
    }
}