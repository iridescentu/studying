import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 17202: 핸드폰 번호 궁합
        // 시간 복잡도: O(n^2)
        // ---------------------------------------------------------
        // * 두 개의 핸드폰 번호에서 010과 -를 제거한 8자리 숫자를 번갈아가며 나열
        // * 가까운 숫자끼리 더한 후 일의 자리를 취하는 과정을 반복해 배열 줄이기
        // * 배열의 길이가 2가 되면 종료하고 출력
        // ---------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 입력 받기
        String A = sc.next();
        String B = sc.next();

        // 초기 배열 생성
        int[] arr = new int[16];
        for (int i = 0; i < 8; i++) {
            arr[2 * i] = A.charAt(i) - '0'; // A의 번호에서 숫자를 차례로 배열에 추가
            arr[2 * i + 1] = B.charAt(i) - '0'; // B의 번호에서 숫자를 차례로 배열에 추가
        }

        // 배열을 줄여나가는 과정
        while (arr.length > 2) {
            int[] newArr = new int[arr.length - 1];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = (arr[i] + arr[i + 1]) % 10; // 인접한 숫자끼리 더한 후 일의 자리만 저장
            }
            arr = newArr; // 새 배열로 교체
        }

        // 결과 출력
        System.out.printf("%d%d\n", arr[0], arr[1]);
    }
}