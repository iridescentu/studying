import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 01. 입출력
        // sout 입력하면 System.out.println(); 자동완성 가능
//        System.out.println("Hello world!");

        // -------------------------------------------------------------------------------------

        // 02. 반복문
        // for 반복문: 특정 조건이 만족될 때까지 코드 블록을 반복 실행함. 초기화 부분, 조건 부분, 증감 부분으로 구성.
//        for(int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
        // for 반복문 예제 - 1부터 10까지의 합 계산하기
//        int sum = 0;
//        for (int i = 0; i <= 10; i++) {
//            sum += i;
//        }
//        System.out.println("Sum: " + sum);

        // while 반복문: 조건이 참인 동안 코드 블록을 반복 실행함
//        int i = 0;
//        while (i < 10) {
//            System.out.println(i);
//            i++;
//        }
        // while 반복문 예제 - 사용자 입력 받아 처리하기 (사용자가 0을 입력할 때까지 반복)
//        Scanner scanner = new Scanner(System.in);
//        int number = 0;
//
//        while(number != -1) {
//            number = scanner.nextInt();
//            System.out.println("You entered: " + number);
//        }

        // do-while 반복문: 조건 검사를 반복문의 끝에서 수행해 최소 한 번은 코드 블록이 실행되도록 함
//        int i = 0;
//        do {
//            System.out.println(i);
//            i++;
//        } while(i < 10);

        // -------------------------------------------------------------------------------------

        // 03. 조건문
        // if 조건문: 주어진 조건이 참(true)인 경우에만 코드 블록 실행
//        int score = 85;
//        if(score > 90) {
//            System.out.println("Grade A");
//        } else if(score > 80) {
//            System.out.println("Grade B");
//        } else {
//            System.out.println("Grade C or below");
//        }

        // switch 조건문
//        int day = 4;
//
//        switch(day) {
//            case 1:
//                System.out.println("Monday");
//                break;
//            case 2:
//                System.out.println("Tuesday");
//                break;
//                // 추가 케이스
//            default:
//                System.out.println("Weekend");
//                break;
//        }

        // -------------------------------------------------------------------------------------

        // 04. 연산자와 표현식
        // 산술 연산자: 기본적인 수학 연산을 수행. +, -, *, /, % 등이 있음
//        int result = 10 + 5;
//        System.out.println("Result: " + result);

        // 산술 연산자 예제: 짝수 판별하기
//        int number = 4;
//
//        if (number%2 == 0) {
//            System.out.println("짝수입니다: " + number);
//        }

        // 비교 연산자: 두 값을 비교한다. ==, !=, >, <, >=, <= 등이 있음
        // 비교 연산자 예제
//        if(a > b) {
//            System.out.println("a is greater than b");
//        }

        // 논리 연산자: 논리적 조건을 평가함. &&, ||, ! 등이 있음.
//        if(a > 10 && b < 5) {
//            System.out.println("Condition met");
//        }

        // 대입 연산자: 변수에 값을 할당함. =, +=, -= 등이 있음
        // 대입 연산자 예제
//        int a = 10;
//        a += 5; // a = a + 5와 동일
//        System.out.println("a: " + a);

    }
}