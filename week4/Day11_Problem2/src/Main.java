import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1440: 타임머신
        // -------------------------------------------------
        // * 주어진 시간 포맷은 "HH:MM:SS"
        // * 가능한 모든 조합을 만들고, 각 조합이 유효한지 확인해야 함
        // * 시간은 01에서 12, 분과 초는 00에서 59 사이에 있어야 함
        // * 가능한 모든 조합을 찾기 위해 주어진 시간을 세 부분으로 나눔
        // * 세 부분의 순서를 바꿔 가며 가능한 조합을 찾아야 함
        // * 각 조합이 유효한지 검사하고, 유효한 조합의 수를 세어야 함
        // -------------------------------------------------

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        // 입력값을 ":" 기준으로 세 부분으로 나누기
        String[] parts = input.split(":");
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];

        // 가능한 모든 조합 생성
        String[][] check = {
                {part1, part2, part3},
                {part1, part3, part2},
                {part2, part1, part3},
                {part2, part3, part1},
                {part3, part1, part2},
                {part3, part2, part1},
        };

        int valid = 0;

        // 각 조합이 유효한지 확인
        for (String[] checkPart : check) {
            if (isValidTime(checkPart[0], checkPart[1], checkPart[2])) {
                valid++;
            }
        }

        // 유효한 조합의 수 출력
        System.out.println(valid);
    }

    // 주어진 시간 조합이 유효한지 확인하는 메소드
    private static boolean isValidTime(String h, String m, String s) {
        int hour = Integer.parseInt(h);
        int minute = Integer.parseInt(m);
        int second = Integer.parseInt(s);

        // 시간, 분, 초의 범위 확인
        return (hour >= 1 && hour <= 12) && (minute >= 0 && minute <= 59) && (second >= 0 && second <= 59);
    }
}