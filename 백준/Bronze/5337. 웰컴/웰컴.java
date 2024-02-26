import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.module.FindException;
import java.sql.Array;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private StringBuilder sb = new StringBuilder();
    private int sum = 0;
    public  void run() throws Exception {
       sb.append(".  .   .\n");
       sb.append("|  | _ | _. _ ._ _  _\n");
       sb.append("|/\\|(/.|(_.(_)[ | )(/.");
       System.out.println(sb);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}