import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        int count=0;
        for (int i = 0; i < testCase; i++) {
            int[] run = new int[2];
            int[] trick = new int[5];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) run[j] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 5; j++) trick[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(run);
            Arrays.sort(trick);

            for (int value : run) sb.append(value).append(" ");
            sb.append("\n");
            for (int value : trick) sb.append(value).append(" ");
            sb.append("\n\n");


            int sum =0;
            sum += run[1];
            sum += trick[3];
            sum += trick[4];
            if(count < sum) count = sum;
        }
        System.out.println(count);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}