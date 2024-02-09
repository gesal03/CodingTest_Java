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
        int min; int max;
        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        min = Integer.parseInt(a.replace('6', '5')) + Integer.parseInt(b.replaceAll("6", "5"));

        max = Integer.parseInt(a.replace("5", "6")) + Integer.parseInt(b.replace("5", "6"));

        System.out.println(min + " " + max);


    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}