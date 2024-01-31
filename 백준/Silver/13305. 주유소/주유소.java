import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Long> distanceList = new ArrayList<Long>();
    private ArrayList<Long> priceList = new ArrayList<Long>();
    private Iterator<Long> it;
    private long sum = 0;

    public  void run() throws Exception {
        int count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<count -1; i++)
            distanceList.add(Long.parseLong(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<count; i++)
            priceList.add(Long.parseLong(st.nextToken()));

        Long minPrice = priceList.get(0);
        for(int i=0; i<count-1; i++){
            Long price = priceList.get(i);
            Long distance = distanceList.get(i);
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