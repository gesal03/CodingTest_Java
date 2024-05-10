import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private LinkedList<Node>[] adjList;
    private boolean[] visited;
    private int endNode;
    private int totalCount = 0;

    private static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    private void dfs(int startNode, int count) {
        visited[startNode] = true;
        if(startNode == endNode) totalCount = count;
        Iterator<Node> it = adjList[startNode].listIterator();
        while (it.hasNext()) {
            Node node = it.next();
            if(!visited[node.index]) dfs(node.index, count + node.distance);
        }
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new LinkedList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            adjList[node1].add(new Node(node2, distance));
            adjList[node2].add(new Node(node1, distance));
        }
        for (LinkedList<Node> list : adjList) {
            list.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.index - o2.index;
                }
            });
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            endNode = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];
            totalCount = 0;
            dfs(startNode, 0);
            sb.append(totalCount).append("\n");
        }
        System.out.println(sb);


    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
