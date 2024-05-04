import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) que.add(i);

        while (que.size() != 1) {
            sb.append(que.poll()).append(" ");
            que.add(que.poll());
        }
        sb.append(que.poll());
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
