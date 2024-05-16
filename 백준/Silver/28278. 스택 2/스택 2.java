import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        Stack<Integer> stack = new Stack<>();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int method = Integer.parseInt(st.nextToken());

            if (method == 1) {
                int X = Integer.parseInt(st.nextToken());
                stack.push(X);
            } else if (method == 2) {
                if (stack.isEmpty()) sb.append("-1").append("\n");
                else sb.append(stack.pop()).append("\n");
            } else if (method == 3) {
                sb.append(stack.size()).append("\n");
            } else if (method == 4) {
                if (stack.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            } else if (method == 5) {
                if (stack.isEmpty()) sb.append("-1").append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
