import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1417: 국회의원 선거
        // --------------------------------------------------
        // * 국회의원에 당선되기 위해 필요한 최소한의 사람 수를 매수해야 함
        // * 다솜이의 득표수가 다른 후보들의 득표수보다 많아야 함
        // --------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 1. 입력 받기
        int n = sc.nextInt(); // 후보 수
        int dasomVotes = sc.nextInt(); // 다솜이의 현재 득표수
        ArrayList<Integer> otherVotes = new ArrayList<>(); // 다른 후보들의 득표수를 저장할 리스트

        // 나머지 후보들의 득표수를 리스트에 저장
        for (int i = 1; i < n; i++) {
            otherVotes.add(sc.nextInt());
        }

        // 2. 매수할 사람의 수를 계산하기
        int bribes = 0; // 매수한 사람의 수를 기록할 변수

        // 다솜이의 득표수가 가장 많아질 때까지 반복
        while (!otherVotes.isEmpty() && Collections.max(otherVotes) >= dasomVotes) {
            // 득표수가 가장 많은 후보를 찾아서 매수
            int maxVotes = Collections.max(otherVotes);
            int index = otherVotes.indexOf(maxVotes);

            // 매수하여 다솜이의 득표수를 증가시키고 해당 후보의 득표수를 감소시킴
            dasomVotes++;
            otherVotes.set(index, maxVotes - 1);
            bribes++;
        }

        // 3. 결과 출력
        System.out.println(bribes);

        sc.close();
    }
}