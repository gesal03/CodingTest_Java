import java.io.BufferedReader;
import java.io.IOError;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();




    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) pq.add(BigInteger.valueOf(Integer.parseInt(st.nextToken())));

        for(int i=0; i<M; i++){
            BigInteger v = pq.poll().add(pq.poll());
            pq.add(v); pq.add(v);
        }
        Iterator<BigInteger> it = pq.iterator();
        BigInteger sum = BigInteger.valueOf(0);
        while(it.hasNext()){
            BigInteger a = it.next();
            sum = sum.add(a);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}