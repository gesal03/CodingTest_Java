import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    private int N;
    private LinkedList<Integer> [] adjList;
    private boolean [] visited;
    private Node resultNode;

    class Node{
        int node;
        int count;
        public Node(int node, int count){
            this.node = node;
            this.count = count;
        }
    }

    private void bfs(int startNode){
        visited = new boolean[N+1];
        int kbNumber = 0;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startNode, 0));
        visited[startNode] = true;
        while(!que.isEmpty()){
            Node node = que.poll();
            Iterator<Integer> it = adjList[node.node].listIterator();
            while(it.hasNext()){
                int nowNode = it.next();
                if(!visited[nowNode]){
                    que.add(new Node(nowNode, node.count+1));
                    kbNumber += node.count+1;
                    visited[nowNode] = true;
                }
            }
        }
        if(kbNumber < resultNode.count){
            resultNode.node = startNode;
            resultNode.count = kbNumber;
        }
        else if(kbNumber == resultNode.count){
            if(resultNode.node > startNode) resultNode.node = startNode;
        }
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new LinkedList[N+1];
        resultNode = new Node(0,N*N);

        for(int i=0; i<=N; i++) adjList[i] = new LinkedList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for(int i=1; i<=N; i++) bfs(i);

        System.out.println(resultNode.node);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}