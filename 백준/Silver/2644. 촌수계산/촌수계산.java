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

    private int bfs(int startNode, int endNode){
        Queue<Node> que = new LinkedList<>();
        boolean isVisited = false;
        int count = 0;
        que.add(new Node(startNode, 0));
        visited[startNode] = true;

        while(!que.isEmpty()){
            Node node = que.poll();
            Iterator<Integer> it = adjList[node.index].listIterator();
            while(it.hasNext()){
                int index = it.next();
                if(!visited[index]){
                    que.add(new Node(index, node.count+1));
                    visited[index] = true;
                    if(index == endNode){
                        isVisited = true;
                        count = node.count+1;
                    }
                }
            }
        }
        if(isVisited) return count;
        else return -1;
    }


    public void run() throws Exception {
        int n = Integer.parseInt(br.readLine()); // node 개수
        adjList = new LinkedList[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++){
            adjList[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); // 간선의 개수

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        System.out.println(bfs(startNode, endNode));

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}