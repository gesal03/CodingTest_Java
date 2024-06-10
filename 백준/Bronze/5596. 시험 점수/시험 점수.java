import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        int minSum=0;
        int manSum=0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minSum += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            manSum += Integer.parseInt(st.nextToken());
        }
        if(minSum >= manSum) System.out.println(minSum);
        else System.out.println(manSum);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}

