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
        list.add(1);list.add(1);list.add(2);list.add(2);list.add(2);list.add(8);
        it = list.iterator();
        st = new StringTokenizer(br.readLine());
        while(it.hasNext()){
            sb.append(it.next() - Integer.parseInt(st.nextToken()) + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}