import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    

    public  void run() throws Exception {
        sb.append("    8888888888  888    88888" + "\n");
        sb.append("   88     88   88 88   88  88" + "\n");
        sb.append("    8888  88  88   88  88888" + "\n");
        sb.append("       88 88 888888888 88   88" + "\n");
        sb.append("88888888  88 88     88 88    888888" + "\n\n");
        sb.append("88  88  88   888    88888    888888" + "\n");
        sb.append("88  88  88  88 88   88  88  88" + "\n");
        sb.append("88 8888 88 88   88  88888    8888" + "\n");
        sb.append(" 888  888 888888888 88  88      88" + "\n");
        sb.append("  88  88  88     88 88   88888888" + "\n");
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}