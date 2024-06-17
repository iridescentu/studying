import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1292: 쉽게 푸는 문제
        // ------------------------------------------------------------------------------
        // * 특정 규칙에 따라 생성된 수열의 일부 구간의 합을 구해야 함
        // * 수열의 생성 규칙을 이해하고 코드로 구현해야 함
        // * 각 숫자 n은 n번 반복되기 때문에 수열에서의 위치를 통해 해당 숫자를 찾을 수 있어야 함
        // * 구간의 시작 A와 끝 B 사이의 모든 숫자를 찾아 합을 구해야 함
        // * 직접 모든 숫자를 생성해 합을 구하는 방법보다는 규칙을 이용해 더 효율적으로 계산하는 방법을 찾아야 함
        // ------------------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        // 수열의 각 숫자를 저장할 변수
        int currentNum = 1;
        // currentNum이 수열에서 반복되는 횟수를 세는 변수
        int repeatCount = 0;
        // 결과값을 저장할 변수
        int sum = 0;

        for (int i = 1; i <= B; i++) { // B까지 숫자를 생성하며 합을 구함
            if (i >= A) { // A 이상인 경우에만
                sum += currentNum;
            }
            repeatCount++; // 현재 숫자를 또 하나 생성했기 때문에 반복 횟수를 증가해야 함

            if (repeatCount == currentNum) { // 현재 숫자의 반복이 끝나면 다음 숫자로 넘어감
                currentNum++; // 다음 숫자
                repeatCount = 0; // 반복 횟수 초기화
            }
        }

        System.out.println(sum);
    }
}