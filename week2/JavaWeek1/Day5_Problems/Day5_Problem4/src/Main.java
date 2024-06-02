import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 1652: 누울 자리를 찾아라

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 방의 크기를 나타내는 n을 입력 받음

        char[][] map = new char[n][n]; // 방의 상태를 저장할 2차원 배열을 선언
        int horizontal = 0; // 가로로 누울 수 있는 공간의 개수를 저장할 변수
        int vertical = 0; // 세로로 누울 수 있는 공간의 개수를 저장할 변수

        // 방의 상태를 입력 받음
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j); // 문자열의 각 문자를 2차원 배열의 요소로 저장
            }
        }

        // 가로와 세로 방향으로 누울 수 있는 공간을 체크
        for(int i = 0; i < n; i++) {
            int check_h = 0, check_v = 0; // 가로, 세로 방향의 연속된 빈 칸을 세는 변수
            for(int j = 0; j < n; j++) {
                // 가로 방향 체크
                if(map[i][j] == '.') check_h++; // 빈 칸이면 check_h를 증가시킴
                if(map[i][j] == 'X' || (j == n-1)) { // 장애물을 만나거나 줄의 끝에 도달하면
                    if(check_h >= 2) horizontal++; // check_h가 2 이상이면 가로로 누울 수 있는 공간이 있음을 의미함
                    check_h = 0; // check_h를 초기화
                }

                // 세로 방향 체크
                if(map[j][i] == '.') check_v++; // 빈 칸이면 check_v를 증가시킴
                if(map[j][i] == 'X' || (j == n-1)) { // 장애물을 만나거나 줄의 끝에 도달하면
                    if(check_v >= 2) vertical++; // check_v가 2 이상이면 세로로 누울 수 있는 공간이 있음을 의미함
                    check_v = 0; // check_v를 초기화
                }
            }
        }

        System.out.println(horizontal + " " + vertical); // 가로와 세로로 누울 수 있는 공간의 개수를 출력
    }
}