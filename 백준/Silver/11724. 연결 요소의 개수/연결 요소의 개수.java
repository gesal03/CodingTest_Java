import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    private LinkedList<Integer> [] adjList;
    private boolean [] visited;
    private int count =0;

    private void bfs(int v){
        Queue<Integer> que = new LinkedList<>();
        que.add(v);
        visited[v] = true;
        while(!que.isEmpty()){
            v = que.poll();
            Iterator<Integer> it = adjList[v].listIterator();
            while(it.hasNext()){
                int w = it.next();
                if(!visited[w]){
                    que.add(w);
                    visited[w] = true;
                }
            }
        }
    }

    public  void run() throws Exception {
       st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

       adjList = new LinkedList[N+1];
       visited = new boolean[N+1];

       for(int i=0; i<=N; i++){
           adjList[i] = new LinkedList<>();
       }

       for(int i=0; i<M; i++){
           st = new StringTokenizer(br.readLine());
           int v1 = Integer.parseInt(st.nextToken());
           int v2 = Integer.parseInt(st.nextToken());
           adjList[v1].add(v2);
           adjList[v2].add(v1);
       }

       for(int i=1; i<=N; i++){
           Collections.sort(adjList[i]);
       }
       for(int i=1; i<=N; i++){
           if(!visited[i]){
               bfs(i);
               count++;
           }
       }
       System.out.println(count);


    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}