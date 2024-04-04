import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int N;
    private int M;
    private int[] numbers;
    private int[] sequence;

    private void dfs(int depth) {
        if (depth == M) {
            for (int value : sequence) sb.append(value).append(" ");
            sb.append("\n");
            return;
        }
        for(int i=0; i<N; i++){
            sequence[depth] = numbers[i];
            dfs(depth+1);
        }
    }


    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        sequence = new int[M];

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