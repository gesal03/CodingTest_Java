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
        int count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<count; i++) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);
        for(int i=0; i<list.size()-1; i++) sum += list.get(i);

        System.out.println(sum);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}