import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private Deque<Integer> deque;
    private boolean isReverse = false;

    private boolean calculate(String command) {
        for (int i = 0; i < command.length(); i++) {
            char method = command.charAt(i);
            if(method == 'R') isReverse = !isReverse;
            else if (method == 'D') {
                if(deque.isEmpty()) return false;
                if (isReverse) {
                    deque.pollLast();
                } else {
                    deque.poll();
                }
            }
        }
        return true;
    }

    public void run() throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String command = br.readLine();
            deque = new ArrayDeque<>();
            int size = Integer.parseInt(br.readLine());

            // 입력된 배열 정재
            String arr = br.readLine();
            String modifiedArr = arr.substring(1, arr.length() - 1);
            st = new StringTokenizer(modifiedArr, ",");

            // 입력된 수 Deque에 삽입
            for (int i = 0; i < size; i++) deque.offer(Integer.parseInt(st.nextToken()));

            // 명령 실행
            isReverse = false;
            if (!calculate(command)) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (deque.size() == 1) {
                        if(isReverse) sb.append(deque.pollLast());
                        else sb.append(deque.poll());
                    } else {
                        if(isReverse) sb.append(deque.pollLast()).append(",");
                        else sb.append(deque.poll()).append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
