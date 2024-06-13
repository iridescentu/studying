// 백준 8911: 거북이
// 시간 복잡도:
// --------------------------------------------------------------------
// * 거북이 로봇의 이동 경로를 추적하여 최소 직사각형의 넓이를 계산해야 함
// * 초기 위치는 (0, 0)이고, 초기 방향은 북쪽임
// * 명령을 읽어가면서 로봇의 위치와 방향을 업데이트해야 함
// * 각 명령이 끝난 후 로봇의 위치를 기록하여 최소 및 최대 x, y 좌표를 추적
// * 최종적으로 최소 및 최대 x, y 좌표를 사용하여 직사각형의 넓이를 계산해야 함
// --------------------------------------------------------------------

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 개수를 입력받음
        sc.nextLine(); // 개행 문자 소모

        for (int t = 0; t < T; t++) {
            String commands = sc.nextLine(); // 각 테스트 케이스의 명령어 입력

            // 초기 위치와 방향 설정
            int x = 0, y = 0;
            int dir = 0; // 0: 북, 1: 동, 2: 남, 3: 서
            int minX = 0, minY = 0, maxX = 0, maxY = 0;

            // 각 명령어에 따라 로봇의 위치와 방향을 업데이트
            for (char command : commands.toCharArray()) {
                if (command == 'F') {
                    if (dir == 0) y++;
                    else if (dir == 1) x++;
                    else if (dir == 2) y--;
                    else if (dir == 3) x--;
                } else if (command == 'B') {
                    if (dir == 0) y--;
                    else if (dir == 1) x--;
                    else if (dir == 2) y++;
                    else if (dir == 3) x++;
                } else if (command == 'L') {
                    dir = (dir + 3) % 4; // 왼쪽 회전
                } else if (command == 'R') {
                    dir = (dir + 1) % 4; // 오른쪽 회전
                }

                // 로봇의 현재 위치를 바탕으로 최소 및 최대 좌표 갱신
                if (x < minX) minX = x;
                if (x > maxX) maxX = x;
                if (y < minY) minY = y;
                if (y > maxY) maxY = y;
            }

            // 직사각형의 넓이 계산
            int area = (maxX - minX) * (maxY - minY);
            System.out.println(area);
        }
        sc.close();
    }
}