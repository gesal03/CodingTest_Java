import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    private LinkedList<Integer> [] adjList;
    private boolean [] visited;

    class Node{
        int node;
        int count;
        public Node(int node, int count){
            this.node = node;
            this.count = count;
        }
    }

    private int bfs(){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1, 0));
        visited[1] = true;
        int count = 0;
        while(!que.isEmpty()){
            Node node = que.poll();
            Iterator<Integer> it = adjList[node.node].listIterator();
            while(it.hasNext()){
                int nowNode = it.next();
                if(!visited[nowNode]){
                    que.add(new Node(nowNode, node.count+1));
                    visited[nowNode] = true;
                    if(node.count+1 <= 2) count++;
                }
            }

        }

        return  count;
    }

    public void run() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        adjList = new LinkedList[n+1];
        visited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            adjList[i] = new LinkedList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        System.out.println(bfs());

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}