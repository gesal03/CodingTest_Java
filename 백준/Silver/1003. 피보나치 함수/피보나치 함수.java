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

    private Integer[][] dp;
    private int num;

    private int recurZero(int N) {
        if (dp[N][0] == null) {
           dp[N][0] = recurZero(N-1) + recurZero(N-2);
        }
        return  dp[N][0];
    }

    private int recurOne(int N) {
        if (dp[N][1] == null) {
            dp[N][1] = recurOne(N-1) + recurOne(N-2);
        }
        return dp[N][1];
    }

    public  void run() throws Exception {
        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++)
            list.add(Integer.parseInt(br.readLine()));

        int n = Collections.max(list);
        dp = new Integer[40+1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        it = list.iterator();
        while(it.hasNext()){
            int now = it.next();
            sb.append(recurZero(now) + " " + recurOne(now) + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}