import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        int language;
        int math;
        if (A % C == 0) language = A / C;
        else language = A / C + 1;

        if (B % D == 0) math = B / D;
        else math = B / D + 1;

        if(language > math) L -= language;
        else L -= math;
        System.out.println(L);

    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}

