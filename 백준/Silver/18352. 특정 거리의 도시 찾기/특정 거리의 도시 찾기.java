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

    private ArrayList<Integer> result;

    class Node{
        int index;
        int count;
        public Node(int index, int count){
            this.index = index;
            this.count = count;
        }
    }

    private void bfs(int startNode, int size){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startNode, 0));
        visited[startNode] = true;
        while(!que.isEmpty()){
            Node node = que.poll();
            Iterator<Integer> it = adjList[node.index].listIterator();
            while(it.hasNext()){
                int nowNode = it.next();
                if(!visited[nowNode]){
                    que.add(new Node(nowNode, node.count+1));
                    visited[nowNode] = true;
                    if(node.count+1 == size) result.add(nowNode);
                }
            }
        }
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // node
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int K = Integer.parseInt(st.nextToken()); // 목표 거리
        int X = Integer.parseInt(st.nextToken()); // 시작 노드

        adjList = new LinkedList[N+1];
        visited = new boolean[N+1];
        result = new ArrayList<>();
        for(int i=0; i<=N; i++) adjList[i] = new LinkedList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adjList[v1].add(v2);
        }
        for(int i=0; i<=N;i++) Collections.sort(adjList[i]);

        bfs(X, K);

        if(result.size() == 0) sb.append("-1");
        else{
            Collections.sort(result);
            for(int i=0; i<result.size(); i++) sb.append(result.get(i)+"\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}
