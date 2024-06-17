import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 백준 21313: 문어
        // ------------------------------------------------------------------------
        // * 이 문제는 사전순으로 제일 앞서는 수열을 구하는 문제
        // * 문어의 손 번호가 1, 2, 3, ... 8로 되어 있으며, 이 규칙을 이용하여 수열을 만듦
        // * N이 짝수일 때는 1, 2 패턴을 반복하여 가장 앞서는 수열을 만들 수 있음
        // * N이 홀수일 경우, 마지막 문어의 손 번호를 1, 2와 다른 번호로 설정하여 규칙을 맞춤
        // ------------------------------------------------------------------------

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 결과 문자열을 생성하기 위해 StringBuilder를 사용
        StringBuilder sb = new StringBuilder();

        // N이 홀수인지 확인
        boolean isOdd = (N % 2 == 1);
        if (isOdd) {
            N--;  // N이 홀수면 1을 줄여 짝수로 만듦
        }

        // 1과 2를 번갈아가며 패턴을 생성하여 StringBuilder에 추가
        for (int i = 0; i < N; i++) {
            // i가 짝수일 때는 1, 홀수일 때는 2를 추가
            if (i % 2 == 0) {
                sb.append("1 ");
            } else {
                sb.append("2 ");
            }
        }

        // N이 홀수였으면 마지막에 3을 추가
        if (isOdd) {
            sb.append("3");
        } else {
            // N이 짝수면 마지막 공백 제거
            sb.setLength(sb.length() - 1);
        }

        System.out.println(sb.toString());
    }
}