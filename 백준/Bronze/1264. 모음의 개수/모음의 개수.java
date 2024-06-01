import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        while (true) {
            int count = 0;
            String str = br.readLine();
            if (str.equals("#")) break;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') count++;
                if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}

