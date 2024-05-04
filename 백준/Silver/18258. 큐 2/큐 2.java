import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    /*
    push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */
    public void run() throws Exception {
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            if (method.equals("push")) {
                deque.offer(Integer.parseInt(st.nextToken()));
            } else if (method.equals("pop")) {
                Integer item = deque.poll();
                if(item != null) sb.append(item).append("\n");
                else sb.append(-1).append("\n");
            } else if (method.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (method.equals("empty")) {
                if(deque.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            } else if (method.equals("front")) {
                Integer item = deque.peek();
                if(item != null) sb.append(item).append("\n");
                else sb.append("-1").append("\n");
            } else if (method.equals("back")) {
                Integer item = deque.peekLast();
                if(item != null) sb.append(item).append("\n");
                else sb.append("-1\n");
            }
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
