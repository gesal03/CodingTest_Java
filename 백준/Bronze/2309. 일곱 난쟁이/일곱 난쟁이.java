import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private int[] numbers;
    private int[] sequence;
    private boolean[] visited;
    private boolean isSuccess = false;

    private void dfs(int depth, int start, int count) {
        if (depth == 7) {
            if (count == 100 && !isSuccess) {
                isSuccess = true;
                Arrays.sort(sequence);
                for (int value : sequence) sb.append(value).append("\n");
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            sequence[depth] = numbers[i];
            dfs(depth + 1, i + 1, count + numbers[i]);
            if (isSuccess) return; // 일곱 난쟁이를 찾았으면 종료
        }
    }

    public void run() throws Exception {
        numbers = new int[9];
        visited = new boolean[9];
        sequence = new int[7];

        for (int i = 0; i < 9; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);

        dfs(0, 0, 0);
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}