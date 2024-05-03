import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();


    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> indexMap = new HashMap<>();
        Map<String, Integer> stringMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            indexMap.put(i + 1, str);
            stringMap.put(str, i + 1);
        }

        for (int i = 0; i < M; i++) {
            String key = br.readLine();
            try {
                int numKey = Integer.parseInt(key);
                sb.append(indexMap.get(numKey)).append("\n");
            } catch (NumberFormatException e) {
                sb.append(stringMap.get(key)).append("\n");
            }
        }

        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
