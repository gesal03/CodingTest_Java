import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
//    private ArrayList<Integer> list;
    private Iterator<Integer> it;
    private int sum = 1;


    public  void run() throws Exception {
         int total = Integer.parseInt(br.readLine());
         for(int i=0; i<total; i++){
             int count = Integer.parseInt(br.readLine());
             Integer [] arr = new Integer[count];
             for(int j=0; j<count;j++){
                 st = new StringTokenizer(br.readLine());
                 arr[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
             }
             int max = 0;
             for(int j=1; j<count; j++){
                 if(arr[max] > arr[j]){
                     sum++;
                     max = j;
                 }
             }
             System.out.println(sum);
             sum=1;
         }




    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}