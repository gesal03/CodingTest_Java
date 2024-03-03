import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();


    public  void run() throws Exception {
        sb.append("     /~\\" + "\n");
        sb.append("    ( oo|" + "\n");
        sb.append("    _\\=/_" + "\n");
        sb.append("   /  _  \\" + "\n");
        sb.append("  //|/.\\|\\\\" + "\n");
        sb.append(" ||  \\ /  ||" + "\n");
        sb.append("============" + "\n");
        sb.append("|          |" + "\n");
        sb.append("|          |" + "\n");
        sb.append("|          |" + "\n");
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}