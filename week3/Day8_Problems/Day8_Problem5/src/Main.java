// 백준 28114: 팀명 정하기
// ------------------------------------------------------
// * 세 팀원의 문제 해결 개수, 입학 연도, 성씨 입력받아 저장하기
// * 입력 데이터는 각각의 팀원에 대해 하나의 객체로 저장하면 관리가 편함
// ------------------------------------------------------

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 팀원 클래스 정의
    static class Member {
        int problemsSolved;
        int admissionYear;
        String surname;

        Member(int problemsSolved, int admissionYear, String surname) {
            this.problemsSolved = problemsSolved;
            this.admissionYear = admissionYear;
            this.surname = surname;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 세 팀원 정보를 입력받아 저장
        Member[] members = new Member[3];
        for (int i = 0; i < 3; i++) {
            int problemsSolved = sc.nextInt();
            int admissionYear = sc.nextInt();
            String surname = sc.next();
            members[i] = new Member(problemsSolved, admissionYear, surname);
        }

        // 첫 번째 방법으로 팀명 생성
        System.out.println(generateFirstTeamName(members));

        // 두 번째 방법으로 팀명 생성
        System.out.println(generateSecondTeamName(members));

        sc.close();
    }

    // 첫 번째 방법으로 팀명 생성
    static String generateFirstTeamName(Member[] members) {
        int[] yearsMod100 = new int[3];
        for (int i = 0; i < 3; i++) {
            yearsMod100[i] = members[i].admissionYear % 100;
        }
        Arrays.sort(yearsMod100);
        StringBuilder teamName = new StringBuilder();
        for (int year : yearsMod100) {
            teamName.append(year);
        }
        return teamName.toString();
    }

    // 두 번째 방법으로 팀명 생성
    static String generateSecondTeamName(Member[] members) {
        Arrays.sort(members, (a, b) -> b.problemsSolved - a.problemsSolved);
        StringBuilder teamName = new StringBuilder();
        for (Member member : members) {
            teamName.append(member.surname.charAt(0));
        }
        return teamName.toString();
    }
}