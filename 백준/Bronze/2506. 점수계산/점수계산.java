import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int count = 0;
        int sum = 0;
        while (T-- > 0) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 1) {
                sum+=++count;
            } else {
                count=0;
            }
        }
        System.out.println(sum);

    }
    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
