import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.module.FindException;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private StringBuilder sb = new StringBuilder();

    private int sum = 0;



    public  void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        sb.append(n.divide(m) + "\n");
        sb.append(n.mod(m));

        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}