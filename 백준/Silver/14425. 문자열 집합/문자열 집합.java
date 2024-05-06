import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        Set<String> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if(set.contains(str)) count++;
        }
        System.out.println(count);

    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
