import java.io.BufferedReader;
import java.io.IOError;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Struct;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private LinkedList<Integer> [] adjList;
    private boolean [] visited;
    private int [] result;
    private void bfs(int startNode){
        int count = 1;
        Queue<Integer> que = new LinkedList<>();
        que.add(startNode);
        visited[startNode] = true;
        result[startNode] = count;
        while(!que.isEmpty()){
            int node = que.poll();
            Iterator<Integer> it = adjList[node].listIterator();
            while(it.hasNext()){
                int nowNode = it.next();
                if(!visited[nowNode]){
                    que.add(nowNode);
                    visited[nowNode] = true;
                    result[nowNode] = ++count;
                }
            }
        }
    }

    public void run() throws Exception {
       st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       int R = Integer.parseInt(st.nextToken());

       adjList = new LinkedList[N+1];
       visited = new boolean[N+1];
       result = new int[N+1];
        for(int i=0; i<=N; i++) {
            adjList[i] = new LinkedList<>();
            result[i] = 0;
        }

       for(int i=0; i<M; i++){
           st = new StringTokenizer(br.readLine());
           int v1 = Integer.parseInt(st.nextToken());
           int v2 = Integer.parseInt(st.nextToken());
           adjList[v1].add(v2);
           adjList[v2].add(v1);
       }
       for(int i=0; i<=N; i++) Collections.sort(adjList[i], new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return o1 < o2 ? 1:-1;
           }
       });
       bfs(R);
       for(int i=1; i<=N; i++) sb.append(result[i] + "\n");
       System.out.println(sb);

    }


    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}