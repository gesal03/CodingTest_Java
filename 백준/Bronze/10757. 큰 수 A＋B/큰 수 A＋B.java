import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();

    private Iterator<String> it;
    private StringBuilder sb = new StringBuilder();
    private int sum = 0;

    public  void run() throws Exception {
        st = new StringTokenizer(br.readLine());

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        A = A.add(B);
        System.out.println(A.toString());
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}