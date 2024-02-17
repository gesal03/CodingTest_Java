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

    public  void run() throws Exception {
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a ==0 && b==0) break;
            if(a > b) sb.append("Yes \n");
            else sb.append("No \n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}