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
        int index;
        int count;
        public Node(int index, int count){
            this.index = index;
            this.count = count;
        }
    }

    private int bfs(int targetNode){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        visited[0] = true;
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.index == targetNode) return node.count;
            Iterator<Integer> it = adjList[node.index].listIterator();
            while(it.hasNext()){
                int nowNode = it.next();
                if(!visited[nowNode]){
                    que.add(new Node(nowNode, node.count+1));
                    visited[nowNode] = true;
                }
            }
        }
        return -1;
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int targetNode = Integer.parseInt(st.nextToken());

        adjList = new LinkedList[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            adjList[i] = new LinkedList<>();
            adjList[i].add(Integer.parseInt(br.readLine()));
        }
        System.out.println(bfs(targetNode));



    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}