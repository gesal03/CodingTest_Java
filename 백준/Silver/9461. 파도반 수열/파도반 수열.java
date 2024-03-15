import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    private BigInteger [] dp;

    private BigInteger recur(int N){
        if(dp[N] == null){
            dp[N] = recur(N-1).add(recur(N-5));
        }
        return dp[N];
    }

    public void run() throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        dp = new BigInteger[101];
        dp[0] = BigInteger.valueOf(0);
        dp[1]= BigInteger.valueOf(1);
        dp[2]= BigInteger.valueOf(1);
        dp[3]= BigInteger.valueOf(1);
        dp[4]= BigInteger.valueOf(2);
        dp[5]= BigInteger.valueOf(2);
        dp[6]= BigInteger.valueOf(3);
        dp[7]= BigInteger.valueOf(4);
        dp[8]= BigInteger.valueOf(5);
        dp[9]= BigInteger.valueOf(7);
        dp[10]= BigInteger.valueOf(9);
        for(int i=0; i<testCase; i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(recur(N) + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}