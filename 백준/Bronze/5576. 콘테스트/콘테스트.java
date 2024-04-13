import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        int[] wUniv = new int[10];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            wUniv[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(wUniv);
        for (int i = 7; i < 10; i++) sum += wUniv[i];
        sb.append(sum).append(" ");

        int[] hUniv = new int[10];
        sum = 0;
        for (int i = 0; i < 10; i++) {
            hUniv[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(hUniv);
        for (int i = 7; i < 10; i++) sum += hUniv[i];
        sb.append(sum).append(" ");

        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}