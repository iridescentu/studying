// 백준 1063: 킹
// ---------------------------------------------------------------------------
// * 체스판은 8 * 8 크기, 킹과 돌의 위치는 알파벳과 숫자로 표현
// * 킹은 여러 방향으로 움직일 수 있고, 돌과 같은 위치로 이동할 때는 돌도 같은 방향으로 한 칸 이동
// * 주어진 이동 명령에 따라 킹과 돌의 위치를 업데이트해야 함
// * 체스판 밖으로 나가는 것은 무시해야 함
// ---------------------------------------------------------------------------

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // 좌표 변환 함수
    private static int[] parsePosition(String pos) {
        return new int[]{pos.charAt(0) - 'A', pos.charAt(1) - '1'};
    }

    // 배열 인덱스를 알파벳과 숫자로 변환하는 함수
    private static String convertPosition(int[] pos) {
        return "" + (char) (pos[0] + 'A') + (pos[1] + 1);
    }

    // 이동 벡터 정의
    private static final Map<String, int[]> moveMap = new HashMap<>();

    static {
        moveMap.put("R", new int[]{1, 0});
        moveMap.put("L", new int[]{-1, 0});
        moveMap.put("B", new int[]{0, -1});
        moveMap.put("T", new int[]{0, 1});
        moveMap.put("RT", new int[]{1, 1});
        moveMap.put("LT", new int[]{-1, 1});
        moveMap.put("RB", new int[]{1, -1});
        moveMap.put("LB", new int[]{-1, -1});
    }

    // 이동 후 위치 계산 함수
    private static int[] move(int[] pos, int[] direction) {
        return new int[]{pos[0] + direction[0], pos[1] + direction[1]};
    }

    // 위치가 체스판 내에 있는지 확인하는 함수
    private static boolean isInBoard(int[] pos) {
        return pos[0] >= 0 && pos[0] < 8 && pos[1] >= 0 && pos[1] < 8;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String kingPosition = sc.next();
        String stonePosition = sc.next();
        int N = sc.nextInt();

        int[] kingPos = parsePosition(kingPosition);
        int[] stonePos = parsePosition(stonePosition);

        for (int i = 0; i < N; i++) {
            String move = sc.next();
            int[] direction = moveMap.get(move);

            int[] newKingPos = move(kingPos, direction);

            // 킹의 새로운 위치가 체스판 내에 있는지 확인
            if (isInBoard(newKingPos)) {
                if (newKingPos[0] == stonePos[0] && newKingPos[1] == stonePos[1]) {
                    // 돌의 새로운 위치 계산
                    int[] newStonePos = move(stonePos, direction);
                    // 돌의 새로운 위치가 체스판 내에 있는지 확인
                    if (isInBoard(newStonePos)) {
                        stonePos = newStonePos;
                        kingPos = newKingPos;
                    }
                } else {
                    kingPos = newKingPos;
                }
            }
        }

        System.out.println(convertPosition(kingPos));
        System.out.println(convertPosition(stonePos));
    }
}