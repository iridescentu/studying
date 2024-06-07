import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 31562: 전주 듣고 노래 맞히기
        // ----------------------------------------------------------------------------------
        // * 정환이가 알고 있는 노래들과 그 노래의 첫 일곱 음을 데이터로 저장하고, 주어진 첫 세 음을 바탕으로
        //   해당하는 노래를 찾아내야 한다. 일치하는 노래가 여러 개라면 "?"를, 하나도 없다면 "!"을 출력
        // * 정환이가 알고 있는 노래의 정보를 저장하기 위해 노래 제목을 key로, 첫 세 음을 value로 하는
        //   HashMap을 사용할 수 있으나, 같은 첫 세 음을 가진 노래가 여러 개일 수 있기 때문에 각 첫 세 음에 대해
        //   노래 제목을 리스트로 관리해야 함.
        // * 사용자로부터 입력받은 첫 세 음을 해시맵에서 검색한 후, 해당하는 노래 제목 리스트를 가져오고,
        //   리스트의 크기에 따라 출력값을 결정.
        // * 대소문자 구분이 중요하니 입력을 처리할 때 이를 유지해야 함.
        // ----------------------------------------------------------------------------------

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // 정환이가 아는 노래의 개수
        int M = scanner.nextInt();  // 맞혀야 할 노래의 개수
        scanner.nextLine();  // 줄 바꿈 처리

        HashMap<String, String> songs = new HashMap<>();  // 첫 세 음과 노래 제목을 저장할 HashMap

        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            String title = input[1];  // 노래 제목
            String notes = input[2] + input[3] + input[4];  // 첫 세 음

            // 만약 이미 같은 첫 세 음으로 시작하는 노래가 있다면 "?"로 업데이트
            songs.put(notes, songs.containsKey(notes) ? "?" : title);
        }

        for (int i = 0; i < M; i++) {
            String[] attempts = scanner.nextLine().split(" ");
            String attemptNotes = attempts[0] + attempts[1] + attempts[2];  // 맞혀야 할 노래의 첫 세 음

            // 첫 세 음으로 노래를 찾아 출력
            System.out.println(songs.getOrDefault(attemptNotes, "!"));
        }

        scanner.close();
    }
}