import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();


    public  void run() throws Exception {
        sb.append("NFC West       W   L  T" + "\n");
        sb.append("-----------------------" + "\n");
        sb.append("Seattle        13  3  0" + "\n");
        sb.append("San Francisco  12  4  0" + "\n");
        sb.append("Arizona        10  6  0" + "\n");
        sb.append("St. Louis      7   9  0" + "\n\n");
        sb.append("NFC North      W   L  T" + "\n");
        sb.append("-----------------------" + "\n");
        sb.append("Green Bay      8   7  1" + "\n");
        sb.append("Chicago        8   8  0" + "\n");
        sb.append("Detroit        7   9  0" + "\n");
        sb.append("Minnesota      5  10  1" + "\n");

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}