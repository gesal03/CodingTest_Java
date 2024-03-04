import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();


    public  void run() throws Exception {
       String jae = br.readLine();
       String doc = br.readLine();
       if(jae.length() >= doc.length()){
           sb.append("go");
       }
       else{
           sb.append("no");
       }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}