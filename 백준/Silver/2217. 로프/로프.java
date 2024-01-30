import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private Iterator<Integer> iterator;
    private int sum = 0;
    private int count;

    public  void run() throws Exception{
        count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        iterator = list.iterator();
        while(iterator.hasNext()){
            int num = iterator.next();
            if(sum < num*count)
                sum = num*count;
            count--;
        }
        System.out.println(sum);

    }


    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}