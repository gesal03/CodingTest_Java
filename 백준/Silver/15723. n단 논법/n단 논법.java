import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int standard = 'z';
    private LinkedList<Integer> [] adjList;
    private boolean [] visited;

    private boolean bfs(int startNode, int endNode){
        Queue<Integer> que = new LinkedList<>();
        que.add(startNode);
        visited[startNode] = true;
        while(!que.isEmpty()){
            int node = que.poll();
            if(node == endNode) return true;
            Iterator<Integer> it = adjList[node].listIterator();
            while(it.hasNext()){
                int nowNode = it.next();
                if(!visited[nowNode]){
                    que.add(nowNode);
                    visited[nowNode] = true;
                }
            }
        }
        return false;
    }
    public void run() throws Exception {
        adjList = new LinkedList[26];
        for(int i=0; i<26; i++) adjList[i] = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = standard - st.nextToken().charAt(0);
            st.nextToken();
            int v2 = standard - st.nextToken().charAt(0);
            adjList[v1].add(v2);
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            visited = new boolean[26];
            int startNode = standard - st.nextToken().charAt(0);
            st.nextToken();
            int endNode = standard - st.nextToken().charAt(0);
            if(bfs(startNode, endNode)) sb.append("T\n");
            else sb.append("F\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}