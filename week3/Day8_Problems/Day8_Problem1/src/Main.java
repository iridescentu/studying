import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 2309: 일곱 난쟁이
        // ---------------------------------------------------------
        // * 아홉 난쟁이의 키 중에서 키의 합이 100이 되는 일곱 난쟁이를 찾아야 함.
        // * 아홉 난쟁이 중 두 명을 제외한 일곱 명의 키의 합이 100이기 때문에,
        //   두 명의 키의 합이 전체 합에서 100을 뺀 값과 같아야 함.
        // * 전체 키의 합을 구하고 두 난쟁이의 키를 찾기.
        // * 두 난쟁이를 제외한 일곱 난쟁이의 키를 오름차순으로 출력.
        // ---------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9];

        // 아홉 난쟁이의 키 입력받기
        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
        }

        // 전체 키의 합 구하기
        int totalHeight = 0;
        for (int height : heights) {
            totalHeight += height;
        }

        // 합이 100이 되기 위해 제외해야 할 두 난쟁이의 키의 합 계산
        int twoHeight = totalHeight - 100;

        // 두 난쟁이 키 찾기
        int dwarf1 = -1, dwarf2 = -1;
        outerLoop:
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (heights[i] + heights[j] == twoHeight) {
                    dwarf1 = i;
                    dwarf2 = j;
                    break outerLoop;
                }
            }
        }

        // 결과 배열 생성 -> 두 난쟁이 키 제외한 나머지 난쟁이들 키 추가
        int[] result = new int[7];
        int index = 0;
        for (int i = 0; i < 9; i++) {
            if (i != dwarf1 && i != dwarf2) {
                result[index++] = heights[i];
            }
        }

        // 결과 배열을 오름차순으로 정렬
        Arrays.sort(result);

        for (int height : result) {
            System.out.println(height);
        }
    }
}