import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();

    private Iterator<String> it;
    private StringBuilder sb = new StringBuilder();
//    private int sum = 0;


    public  void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // y
        int m = Integer.parseInt(st.nextToken()); // x
        Boolean [][] chess = new Boolean[m][n];

        // 체스판 입력
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                if(str.charAt(j) == 'B') chess[j][i] = true;
                else chess[j][i] = false;
            }
        }
        int min = 64;
        for(int i=0; i<m-7; i++){
            for(int j=0; j<n-7; j++){
                boolean color = chess[i][j];
                int sum = 0;
                for(int k=i; k<i+8; k++){
                    for(int z=j; z<j+8; z++){
                        if(chess[k][z] != color){
                            sum++;
                        }
                        color = !color;
                    }
                    color = !color;
                }
                sum = Math.min(sum, 64-sum);
                min = Math.min(min, sum);
            }
        }

        System.out.println(min);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}