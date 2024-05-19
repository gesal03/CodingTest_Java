import java.io.BufferedReader;
import java.io.IOError;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();


    public void run() throws Exception {
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());
        for (int n : list) {
            sb.append(n).append("\n");
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
