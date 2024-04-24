import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        List<Character> charList = new ArrayList<>();
        charList.add('a');charList.add('e');charList.add('i');charList.add('o');charList.add('u');
        String str = br.readLine();
        int count =0;
        for (int i = 0; i < str.length(); i++) {
            if(charList.contains(str.charAt(i))) count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
