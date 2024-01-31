import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private ArrayList<Integer> list2 = new ArrayList<Integer>();
    private Iterator<Integer> it;
    private long sum = 0;

    public  void run() throws Exception {
        int count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int firstDistance = Integer.parseInt(st.nextToken());
        int distacneSum = 0;
        for(int i=0; i<count -2; i++)
            distacneSum+=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int firstPrice = Integer.parseInt(st.nextToken());
        for(int i=0; i<count-2; i++)
            list.add(Integer.parseInt(st.nextToken()));
        int minPrice = Collections.min(list);
        sum += firstDistance*firstPrice;
        sum+=distacneSum*minPrice;
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}