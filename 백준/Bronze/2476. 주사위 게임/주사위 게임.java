import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        int T = Integer.parseInt(br.readLine());
        int total = 0;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < 3; i++) {
                int n = Integer.parseInt(st.nextToken());
                if (map.containsKey(n)) map.put(n, map.get(n) + 1);
                else map.put(n, 1);
            }
            Set<Integer> keySet = map.keySet();
            int sum = 0;
            Iterator<Integer> it = keySet.iterator();
            int n = 0;
            if (keySet.size() == 1) {
                while (it.hasNext()) n = it.next();
                sum = 10000 + n * 1000;
            } else if (keySet.size() == 2) {
                while (it.hasNext()) {
                    int m = it.next();
                    if(map.get(m) == 2) n = m;
                }
                sum = 1000 + n * 100;
            } else {
                while (it.hasNext()) {
                    int m = it.next();
                    if(m > n) n=m;
                }
                sum = n * 100;
            }
            if(sum > total) total = sum;
        }
        System.out.println(total);

    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
