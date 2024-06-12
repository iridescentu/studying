import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2061: 좋은 암호
        // ------------------------------------------------------
        // * 주어진 K를 소인수분해하고 각 인수가 L 이상인지 확인해야 함
        // * 입력 제한을 고려할 때 큰 수에 대해 빠르게 소인수분해를 하기 위해
        //   에라토스테네스체를 사용해 소수를 구하고, K를 나눠 인수를 찾아야 함
        // * 에라토스테네스체를 사용해 L 미만의 모든 소수를 구해야 함
        // * K를 위 소수들로 나눠 보면서 인수분해를 시도하기
        // * 만약 L 미만의 소수로 K를 나눌 수 있다면 "BAD"와 소수 출력
        // * 모든 소수로 나눌 수 없다면 "GOOD" 출력
        // ------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        String kString = sc.next();
        int L = sc.nextInt();
        sc.close();

        BigInteger K = new BigInteger(kString);

        // 에라토스테네스체를 이용해 L 미만의 모든 소수 구하기
        boolean[] isPrime = new boolean[L];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아님

        for (int i = 2; i < L; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < L; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수 리스트 만들기
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < L; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // K를 소수로 나눠 보면서 인수분해 시도
        for (int prime : primes) {
            if (K.mod(BigInteger.valueOf(prime)).equals(BigInteger.ZERO)) {
                // L 미만의 소수로 나눌 수 있다면 BAD와 소수 출력
                System.out.println("BAD " + prime);
                return;
            }
        }

        // 모든 소수로 나눌 수 없다면 GOOD 출력
        System.out.println("GOOD");
    }
}