import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<Integer> timeList = new ArrayList<Integer>();
    private int sum = 0;
    private int netSum = 0;
    public  void run() throws Exception{
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<count; i++){
            int num = Integer.parseInt(st.nextToken());
            timeList.add(num);
        }
        Collections.sort(timeList);
        for(int i=0; i<timeList.size(); i++){
            netSum += timeList.get(i);
            sum+=netSum;
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}