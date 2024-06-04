import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1244: 스위치 켜고 끄기

        Scanner sc = new Scanner(System.in);

        int countSwitch = sc.nextInt(); // 스위치 개수
        int[] switches = new int[countSwitch];

        // 스위치 초기 상태
        for (int i = 0; i < countSwitch; i++) {
            switches[i] = sc.nextInt();
        }

        int countStudent = sc.nextInt(); // 학생 수

        for (int i = 0; i < countStudent; i++) {
            int gender = sc.nextInt();
            int count = sc.nextInt();

            // 남학생
            if (gender == 1) {
                for (int j = count - 1; j < countSwitch; j += count) {
                    switches[j] = switches[j] == 0 ? 1 : 0;
                }
            } else if (gender == 2) { // 여학생
                int left = count - 2;
                int right = count;

                switches[count - 1] = switches[count - 1] == 0 ? 1 : 0;

                while (left >= 0 && right < countSwitch && switches[left] == switches[right]) {
                    switches[left] = switches[left] == 0 ? 1 : 0;
                    switches[right] = switches[right] == 0 ? 1 : 0;
                    left--;
                    right++;
                }
            }
        }

        for (int i = 0; i < countSwitch; i++) {
            System.out.print(switches[i] + " ");
            if ((i + 1) % 20 == 0) System.out.println();
        }
        sc.close();
    }
}