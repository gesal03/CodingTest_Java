import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();

    private Iterator<Integer> it;
    private StringBuilder sb = new StringBuilder();
//    private int sum = 0;


    public  void run() throws Exception {
        int count = Integer.parseInt(br.readLine());
        int [] arr = new int[count];
        for(int i =0; i<count; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        for(int i =0; i<count; i++)
            sb.append(arr[i] + "\n");
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}