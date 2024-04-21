import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    private int count(int time, int alcol) {
        if (alcol == 1) {
            return 280;
        } else {
            if(time >= 12 && time <= 16) return 320;
            else return 280;
        }
    }
    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int alcol = Integer.parseInt(st.nextToken());
        System.out.println(count(time, alcol));
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
