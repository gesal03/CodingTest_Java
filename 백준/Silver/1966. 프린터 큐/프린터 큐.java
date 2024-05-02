import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> que = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                que.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }
            int count = 0;
            while (!que.isEmpty()) {
                int[] first = que.poll();
                boolean isMax = true;

                for (int i = 0; i < que.size(); i++) {
                    if (first[1] < que.get(i)[1]) {
                        que.offer(first);
                        for (int j = 0; j < i; j++) que.offer(que.poll());
                        isMax = false;
                        break;
                    }
                }
                if (isMax){
                    count++;
                    if(first[0] == M) break;
                }

            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
