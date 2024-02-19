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
           dp[N] = recur(N-1) + recur(N-2) + recur(N-3);
        }
        return dp[N];
    }


    public  void run() throws Exception {
        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++)
            list.add(Integer.parseInt(br.readLine()));

        int n = Collections.max(list);
        dp = new Integer[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        it = list.iterator();
        while(it.hasNext()){
            System.out.println(recur(it.next()));
        }
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}