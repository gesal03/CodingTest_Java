import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();




    public void run() throws Exception {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0; i<N-1; i++) pq.poll();
        System.out.println(pq.poll());
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}