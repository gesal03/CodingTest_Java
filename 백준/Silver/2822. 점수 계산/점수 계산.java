import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        for (int k = 1; k <= 8; k++) {
            int n = Integer.parseInt(br.readLine());
            map.put(n, k);
            list.add(n);
        }

        list.sort(Collections.reverseOrder());
        LinkedList<Integer> indexList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            int n = list.get(i);
            sum += n;
            indexList.add(map.get(n));
        }
        Collections.sort(indexList);

        sb.append(sum).append("\n");
        for (int n : indexList) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}

