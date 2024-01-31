import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> distanceList = new ArrayList<Integer>();
    private ArrayList<Integer> priceList = new ArrayList<Integer>();
    private Iterator<Integer> it;
    private long sum = 0;

    public  void run() throws Exception {
        int count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<count -1; i++)
            distanceList.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<count; i++)
            priceList.add(Integer.parseInt(st.nextToken()));

        int minPrice = priceList.get(0);
        for(int i=0; i<count-1; i++){
            int price = priceList.get(i);
            int distance = distanceList.get(i);
            if(minPrice > price)
                minPrice = price;
            sum+= minPrice * distance;
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}