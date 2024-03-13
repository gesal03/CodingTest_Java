import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    private LinkedList<Integer> [] adjList;
    private boolean [] visited;

    private void dfs(int node){
       visited[node] = true;
       sb.append(node + " ");
       Iterator<Integer> it = adjList[node].listIterator();
       while(it.hasNext()){
           int nowNode = it.next();
           if(!visited[nowNode]){
               visited[nowNode] = true;
               dfs(nowNode);
           }
       }
    }

    private void bfs(int startNode){
        Queue<Integer> que = new LinkedList<>();
        que.add(startNode);
        visited[startNode] = true;
        while(!que.isEmpty()){
            int node = que.poll();
            sb.append(node + " ");
            Iterator<Integer> it = adjList[node].listIterator();
            while(it.hasNext()){
                int nowNode = it.next();
                if(!visited[nowNode]){
                    que.add(nowNode);
                    visited[nowNode] = true;
                }
            }
        }
        sb.append("\n");
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        adjList = new LinkedList[N+1];

        for(int i=0; i<=N; i++) adjList[i] = new LinkedList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        for (int i=0; i<=N; i++) Collections.sort(adjList[i]);

        // DFS
        visited = new boolean[N+1];
        dfs(startNode);
        sb.append("\n");

        //BFS
        visited = new boolean[N+1];
        bfs(startNode);

        System.out.println(sb);


    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}