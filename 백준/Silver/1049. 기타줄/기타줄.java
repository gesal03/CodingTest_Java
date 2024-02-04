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
         st = new StringTokenizer(br.readLine());
         int count = Integer.parseInt(st.nextToken());
         int index = Integer.parseInt(st.nextToken());

         st = new StringTokenizer(br.readLine());
         int minSix = Integer.parseInt(st.nextToken());
         int minOne = Integer.parseInt(st.nextToken());

         for(int i=1; i<index; i++){
             st = new StringTokenizer(br.readLine());
             int six = Integer.parseInt(st.nextToken());
             int one = Integer.parseInt(st.nextToken());
             if(six < minSix) minSix = six;
             if(one < minOne) minOne = one;
         }

         // 6개 묶음으로 다 사기
        list.add(minSix * ((count / 6) + 1));
        // 낱개로 사기
        list.add(minOne * count);
        // 6개 묶음과 낱개 섞어서 사기
        list.add(minSix*(count/6) + minOne*(count%6));
        System.out.println(Collections.min(list));
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}