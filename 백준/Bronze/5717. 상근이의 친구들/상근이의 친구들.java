import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    public void run() throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if(M==0 && N==0) break;
            sb.append(M + N).append("\n");
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}

