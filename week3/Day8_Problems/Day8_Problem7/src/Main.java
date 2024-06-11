import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 백준 18870: 좌표 압축
        // --------------------------------------------------------------------
        // * 첫 번째 줄에서 N을 읽고 두 번째 줄에서 좌표값 배열 읽어오기
        // * 좌표값 배열을 집합으로 변환해 중복을 제거한 후 정렬하기
        // * 정렬된 좌표값을 순회하면서 각 좌표에 대해 순위를 부여
        // * 순위를 매긴 결과를 해시맵에 저장해 원래 배열의 각 좌표에 대해 순위를 찾을 수 있도록 함
        // * 원래 배열의 각 좌표에 대해 해시맵을 사용해 순위를 찾고 순서대로 출력
        // --------------------------------------------------------------------

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // * 첫 번째 줄에서 N을 읽어옴
        int N = Integer.parseInt(st.nextToken());

        // * 두 번째 줄에서 좌표값 배열을 읽어옴
        int[] coords = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coords[i] = Integer.parseInt(st.nextToken());
        }

        // * 중복 제거 및 정렬을 위해 좌표값 배열을 집합(Set)으로 변환하고 정렬된 리스트로 변환
        Set<Integer> sortedSet = new TreeSet<>();
        for (int coord : coords) {
            sortedSet.add(coord);
        }

        // * 정렬된 집합을 리스트로 변환
        List<Integer> sortedList = new ArrayList<>(sortedSet);

        // * 각 좌표에 대한 순위를 저장할 해시맵을 생성
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < sortedList.size(); i++) {
            rankMap.put(sortedList.get(i), i);
        }

        // * 원래 배열의 각 좌표에 대해 순위를 찾아 출력
        StringBuilder sb = new StringBuilder();
        for (int coord : coords) {
            sb.append(rankMap.get(coord)).append(' ');
        }

        // * 결과 출력
        System.out.println(sb.toString().trim());
    }
}