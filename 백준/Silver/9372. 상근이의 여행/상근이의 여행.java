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

    private void bfsList(int v, LinkedList<Integer> [] adjList, boolean [] visited){
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);
        while(queue.size() != 0){
            v = queue.poll();
            Iterator<Integer> it = adjList[v].listIterator();
            while(it.hasNext()){
                int w = it.next();
                if(!visited[w]){
                    sum++;
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }
    public  void run() throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            sum = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            boolean [] visited = new boolean[N+1];
            LinkedList<Integer> [] adjList = new LinkedList[N+1];

            for(int j=0; j<=N; j++){
                adjList[j] = new LinkedList();
            }
            for(int j=0; j<M; j++){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                adjList[v1].add(v2);
                adjList[v2].add(v1);
            }
            for(int j=0; j<=N; j++){
                Collections.sort(adjList[j]);
            }
            bfsList(1, adjList, visited);
            sb.append(sum+"\n");
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}