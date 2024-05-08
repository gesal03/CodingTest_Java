import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws Exception {
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>(); // 카드의 숫자를 long 타입으로 저장

        while (N-- > 0) {
            long card = Long.parseLong(br.readLine()); // 입력 받은 카드 값을 long으로 파싱
            map.merge(card, 1, Integer::sum); // 카드의 수를 증가시키거나 새로운 값으로 추가
        }

        List<Map.Entry<Long, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<Long, Integer>>() {
            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return Long.compare(o1.getKey(), o2.getKey()); // 값이 같으면 키를 기준으로 오름차순 정렬
                }
                return o2.getValue() - o1.getValue(); // 빈도수 내림차순으로 정렬
            }
        });

        System.out.println(entryList.get(0).getKey()); // 가장 빈도수가 높은 카드 출력
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
