import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> alist = new ArrayList<Integer>();
    private ArrayList<Integer> blist = new ArrayList<Integer>();
    private Iterator<Integer> aIterator = alist.iterator();
    private Iterator<Integer> bIterator = blist.iterator();
    private int sum = 0;

    public  void run() throws Exception{
        int count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<count; i++){
            alist.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<count; i++){
            blist.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(alist);
        Collections.sort(blist);
        for(int i=0; i<alist.size(); i++){
            sum += alist.get(i)*blist.get(blist.size()-i-1);
        }
        System.out.println(sum);

    }


    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}