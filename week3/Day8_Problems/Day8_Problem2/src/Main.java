import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 백준 11557: Yangjojang of Year
        // ---------------------------------------------------------------------
        // * 주어진 학교들의 술 소비량을 비교해 가장 많이 소비한 학교 이름 출력
        // * 입력으로 주어진 학교의 숫자와 각 학교의 술 소비량을 받아 처리
        // * 학교의 숫자만큼 반복해 각 학교의 이름과 술 소비량 입력받기
        // * 술 소비량이 가장 많은 학교를 찾기 위해 현재까지의 최대 술 소비량과 학교의 이름 저장
        // ---------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수 T 입력받기

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt(); // 학교 수 N 입력받기
            sc.nextLine();

            String maxSchool = ""; // 술 소비 가장 많은 학교의 이름을 저장할 변수
            int maxDrinks = -1; // 가장 많이 소비한 술의 양을 저장할 변수. 초기값은 가장 작은 값으로 설정

            for (int j = 0; j < N; j++) {
                String input = sc.nextLine(); // 학교 이름, 술 소비량 입력받기
                String[] parts = input.split(" "); // 공백 기준으로 분리

                String school = parts[0]; // 학교 이름
                int drinks = Integer.parseInt(parts[1]); // 술 소비량

                // 술 소비량이 현재까지의 최대 소비량보다 많을 때 정보 업데이트
                if (drinks > maxDrinks) {
                    maxDrinks = drinks;
                    maxSchool = school;
                }
            }

            System.out.println(maxSchool); // 술 소비 가장 많은 학교 이름 출력
        }
    }
}