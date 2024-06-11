import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2304: 창고 다각형
        // -------------------------------------------------------
        // * 주어진 기둥들의 위치와 높이를 사용해 창고 다각형의 면적을 구해야 함
        // * 기둥의 위치와 높이를 저장하기 위해 리스트 사용
        // * 기둥들을 위치에 따라 정렬
        // * 최대 높이의 기둥 찾기
        // * 최대 높이 기둥을 기준으로 왼쪽, 오른쪽 면적 계산
        // * 계산된 면적을 합해 최종 면적 구하기
        // -------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 기둥의 개수 입력
        int n = sc.nextInt();

        // 기둥의 위치와 높이를 저장할 리스트
        List<int[]> pillars = new ArrayList<>();

        // 기둥의 위치와 높이 입력
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int h = sc.nextInt();
            pillars.add(new int[]{l, h});
        }

        // 기둥을 위치에 따라 정렬
        Collections.sort(pillars, (a, b) -> a[0] - b[0]);

        // 최대 높이의 기둥을 찾음
        int maxIndex = 0;
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            if (pillars.get(i)[1] > maxHeight) {
                maxHeight = pillars.get(i)[1];
                maxIndex = i;
            }
        }

        // 왼쪽에서 오른쪽으로 면적을 계산
        int area = 0;
        int currentHeight = pillars.get(0)[1];
        int currentPosition = pillars.get(0)[0];
        for (int i = 1; i <= maxIndex; i++) {
            if (pillars.get(i)[1] > currentHeight) {
                area += currentHeight * (pillars.get(i)[0] - currentPosition);
                currentHeight = pillars.get(i)[1];
                currentPosition = pillars.get(i)[0];
            }
        }
        area += currentHeight * (pillars.get(maxIndex)[0] - currentPosition);

        // 오른쪽에서 왼쪽으로 면적을 계산
        currentHeight = pillars.get(n - 1)[1];
        currentPosition = pillars.get(n - 1)[0];
        for (int i = n - 2; i >= maxIndex; i--) {
            if (pillars.get(i)[1] > currentHeight) {
                area += currentHeight * (currentPosition - pillars.get(i)[0]);
                currentHeight = pillars.get(i)[1];
                currentPosition = pillars.get(i)[0];
            }
        }
        area += currentHeight * (currentPosition - pillars.get(maxIndex)[0]);

        // 최대 높이 기둥의 면적을 더함
        area += maxHeight;

        // 최종 면적 출력
        System.out.println(area);
    }
}