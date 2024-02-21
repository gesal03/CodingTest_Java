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

    public  void run() throws Exception {
        int count = Integer.parseInt(br.readLine());
        Integer [][] arr = new Integer[count][3];
        Integer [][] ans = new Integer[count][3];
        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        ans[0][0] = arr[0][0];
        ans[0][1] = arr[0][1];
        ans[0][2] = arr[0][2];

        for(int i=1; i<count; i++){
            ans[i][0] = Math.min(ans[i-1][1], ans[i-1][2]) + arr[i][0];
            ans[i][1] = Math.min(ans[i-1][0], ans[i-1][2]) + arr[i][1];
            ans[i][2] = Math.min(ans[i-1][0], ans[i-1][1]) + arr[i][2];
        }
        System.out.println(Math.min(Math.min(ans[count-1][0], ans[count-1][1]), ans[count-1][2]));

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}