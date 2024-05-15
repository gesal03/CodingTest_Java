import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        LinkedList<Integer> deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;
        int[] sequence = new int[M];

        for (int i = 1; i <= N; i++) deque.offerLast(i);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) sequence[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            int target = deque.indexOf(sequence[i]);
            int half;
            if(deque.size() % 2 == 0) half = deque.size() / 2 - 1;
            else half = deque.size() / 2;

            if (target <= half) {
                for (int j = 0; j < target; j++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            } else {
                for (int j = 0; j < deque.size() - target; j++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
