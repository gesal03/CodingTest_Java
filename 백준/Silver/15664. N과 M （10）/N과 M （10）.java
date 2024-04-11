import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private int N;
    private int M;
    private int[] numbers;
    private int[] sequence;
    private boolean[] visited;

    private void dfs(int depth) {
        if (depth == M) {
            for (int value : sequence) sb.append(value).append(" ");
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (depth > 0 && before != numbers[i] && sequence[depth - 1] <= numbers[i]) {
                visited[i] = true;
                sequence[depth] = numbers[i];
                before = numbers[i];
                dfs(depth + 1);
                visited[i] = false;
            } else if (depth == 0 && before !=numbers[i]) {
                visited[i] = true;
                sequence[depth] = numbers[i];
                before = numbers[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }


    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        sequence = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);

        dfs(0);
        System.out.println(sb);


    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}