import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        Queue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            int v = Integer.parseInt(br.readLine());
            if(v == 0) {
                if(que.isEmpty()) sb.append("0\n");
                else sb.append(que.poll() + "\n");
            }
            else que.add(v);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}