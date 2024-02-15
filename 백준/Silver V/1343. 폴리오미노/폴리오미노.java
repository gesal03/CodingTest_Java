import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();

    private Iterator<String> it;
    private StringBuilder sb = new StringBuilder();
    private int sum = 0;

    void makeString(int count, Boolean isLast){
        while(count != 0){
            if(count >= 4){
                sb.append("AAAA");
                count -= 4;
            }
            else{
                sb.append("BB");
                count -= 2;
            }
        }
        if(isLast) sb.append(".");
    }
    public  void run() throws Exception {
        String str = br.readLine();
        int count = 0;
        boolean isFail = false;
        for(int i=0; i<str.length(); i++){
//            System.out.println(sb);
            if(str.charAt(i) == 'X'){
                count++;
                if(i == str.length()-1) {
                    if(count % 2 == 0)
                        makeString(count, false);
                    else{
                        isFail = true;
                        break;
                    }
                }
            }
            else if(str.charAt(i) == '.'){
                if(count != 0){
                    if(count % 2 == 0){
                       makeString(count, true);
                       count = 0;
                    }
                    else{
                        isFail = true;
                        break;
                    }
                }
                else{
                    sb.append(".");
                    count = 0;
                }
            }
        }
        if(isFail) System.out.println(-1);
        else System.out.println(sb);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}