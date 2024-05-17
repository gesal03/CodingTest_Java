import java.io.BufferedReader;
import java.io.IOError;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[L];

        for (int i = 0; i < L; i++) {
            String str = br.readLine();
            map.put(str, i);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            arr[entry.getValue()] = entry.getKey();
        }

        int count = 0;
        for (String s : arr) {
            if (count == K) break;
            if(s != null){
                sb.append(s).append("\n");
                count++;
            }
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
