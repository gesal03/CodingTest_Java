import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private LinkedList<Integer> [] adjList;
    private boolean [] visited;
    private int [] result;

    private void bfs(){
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visited[1] = true;
        while(!que.isEmpty()){
            int node = que.poll();
            Iterator<Integer> it = adjList[node].listIterator();
            while(it.hasNext()){
                int nowNode = it.next();
                if(!visited[nowNode]){
                    que.add(nowNode);
                    visited[nowNode] = true;
                    result[nowNode] = node;
                }
            }
        }

    }

    public void run() throws Exception {
        int N = Integer.parseInt(br.readLine());
        adjList = new LinkedList[N+1];
        visited = new boolean[N+1];

        result = new int[N+1];
        for(int i=0; i<=N; i++){
            adjList[i] = new LinkedList<>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for(int i=0; i<=N; i++){
            Collections.sort(adjList[i]);
        }

        bfs();
        for(int i=2; i<=N; i++){
            sb.append(result[i] + "\n");
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}