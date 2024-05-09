import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private LinkedList<Integer>[] adjList;
    private boolean[] visited;
    private int deletedNode;
    int count = 0;

    private void dfs(int startNode) {
        visited[startNode] = true;

        Iterator<Integer> it = adjList[startNode].listIterator();
        if (!it.hasNext() && startNode != deletedNode) {
            count++;
        } else {
            while (it.hasNext()) {
                int node = it.next();
                if(!visited[node]) dfs(node);
            }
        }
    }
    public void run() throws Exception {
        int T = Integer.parseInt(br.readLine());
        visited = new boolean[T];
        adjList = new LinkedList[T];
        for (int i = 0; i < T; i++) adjList[i] = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        deletedNode = Integer.parseInt(br.readLine());
        int startNode=0;
        for (int i = 0; i < T; i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            if(parentNode == -1)
                startNode = i;
            else if(parentNode != deletedNode && i != deletedNode)
                adjList[parentNode].add(i);
        }
        for (int i = 0; i < T; i++) Collections.sort(adjList[i]);

//        adjList[deletedNode].clear();

        dfs(startNode);
        System.out.println(count);


    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
