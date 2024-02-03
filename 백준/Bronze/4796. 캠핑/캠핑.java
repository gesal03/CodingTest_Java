import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private Iterator<Integer> it;
    private int sum = 0;


    public  void run() throws Exception {
        int i =1;
        while(true){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(l == 0) break;

            int last = v % p;
            if(last > l) last = l;
            int n = l * (v / p);
            System.out.println("Case " + i + ": " + (last+n));
            i++;

        }
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}