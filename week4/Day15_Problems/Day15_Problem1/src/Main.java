import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1145: 적어도 대부분의 배수
        // ------------------------------------------------------
        // * 다섯 개의 수 중 세 개를 선택하는 모든 조합을 구해야 함
        // * 각 조합에 대해 최소 공배수 계산
        // * 계산된 최소 공배수 중 가장 작은 값 찾기
        // ------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        // 다섯 개의 자연수를 입력받음
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
        }

        // 최소값을 큰 값으로 초기화
        int minLCM = Integer.MAX_VALUE;

        // 다섯 개 중 세 개를 선택하는 모든 조합을 구함
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    // 선택된 세 수의 최소 공배수를 구함
                    int lcm = lcm(numbers[i], numbers[j], numbers[k]);
                    // 최소 공배수를 갱신
                    if (lcm < minLCM) {
                        minLCM = lcm;
                    }
                }
            }
        }

        // 적어도 대부분의 배수 출력
        System.out.println(minLCM);
    }

    // 두 수의 최대 공약수를 구하는 함수 (유클리드 호제법)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 두 수의 최소 공배수를 구하는 함수
    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    // 세 수의 최소 공배수를 구하는 함수
    public static int lcm(int a, int b, int c) {
        return lcm(lcm(a, b), c);
    }
}