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
            int[] numbers = new int[10];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) numbers[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(numbers);

            sb.append(numbers[7]).append("\n");
        }
        System.out.println(sb);


    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}