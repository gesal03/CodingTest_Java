import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int[] numbers = new int[5];
            for (int j = 0; j < 5; j++) numbers[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(numbers);
            if (numbers[3] - numbers[1] >= 4) {
                sb.append("KIN\n");
            } else {
                int sum=0;
                for (int j = 1; j < 4; j++) sum += numbers[j];
                sb.append(sum).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
