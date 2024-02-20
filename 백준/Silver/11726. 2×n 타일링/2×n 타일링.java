import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();

    private Iterator<Integer> it;
    private StringBuilder sb = new StringBuilder();

    private Integer[] dp;

    private int recur(int N) {
        if (dp[N] == null) {
           dp[N] = (recur(N-1) + recur(N-2)) % 10007;
        }
        return dp[N];
    }



    public  void run() throws Exception {
        dp = new Integer[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        sb.append(recur(Integer.parseInt(br.readLine())));

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}
