import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Integer> people = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0; // 시작 인덱스
        while (!people.isEmpty()) {
            index = (index + K - 1) % people.size(); // K-1번 이동하고 현재 인덱스에서 계산
            sb.append(people.remove(index)).append(", "); // K번째 사람을 제거하고 결과 문자열에 추가
        }

        // 마지막 쉼표와 공백 제거 후 결과 출력
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb.toString());
    }
}
