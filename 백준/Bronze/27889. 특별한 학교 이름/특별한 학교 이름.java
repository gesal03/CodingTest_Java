import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    public void run() throws Exception {
        String name = br.readLine();
        if(name.compareTo("NLCS") == 0) System.out.println("North London Collegiate School");
        else if(name.compareTo("BHA") == 0) System.out.println("Branksome Hall Asia");
        else if(name.compareTo("KIS") == 0) System.out.println("Korea International School");
        else System.out.println("St. Johnsbury Academy");
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
