import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        int num = Integer.parseInt(br.readLine());
        System.out.println(num - 1946);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
