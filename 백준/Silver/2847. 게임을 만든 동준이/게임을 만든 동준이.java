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
        for(int i=0; i<count;i++)
            list.add(Integer.parseInt(br.readLine()));
//        System.out.println(list);

       for(int i=list.size()-2; i>=0; i--){
           int pre = list.get(i+1);
           int present = list.get(i);
            if(pre<=present){
                while(pre <= present){
                    present--;
                    sum++;
                }
                list.set(i, present);
            }
       }
//       System.out.println(list);
       System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}