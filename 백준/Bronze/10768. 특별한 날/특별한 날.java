import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    private String isBefore(int month, int day) {
        if(month == 1) return "Before";
        else if (month == 2) {
            if (day < 18) return "Before";
            else if(day == 18) return "Special";
            else return "After";
        } else {
            return "After";
        }
    }

    public void run() throws Exception {
        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());
        System.out.println(isBefore(month, day));
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
