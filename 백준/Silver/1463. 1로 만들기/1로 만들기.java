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
    private int sum = 0;

    private Integer[] dp;

    private int recur(int N) {
        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(recur(N / 3), Math.min(recur(N / 2), recur(N - 1))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N/3), recur(N-1))+1;
            }
            else if(N % 2 == 0){
                dp[N] = Math.min(recur(N/2), recur(N-1))+1;
            }
            else{
                dp[N] = recur(N-1) +1;
            }
        }
        return dp[N];
    }


    public  void run() throws Exception {
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1];
        dp[0] = dp[1] =0;
        System.out.println(recur(n));
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}