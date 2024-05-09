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
        // Node의 개수
        int T = Integer.parseInt(br.readLine());
        // 방문처리 배열 초기화
        visited = new boolean[T];
        // 트리 배열 초기화
        adjList = new LinkedList[T];
        for (int i = 0; i < T; i++) adjList[i] = new LinkedList<>();

        // 트리 입력
        st = new StringTokenizer(br.readLine());
        // 삭제할 노드
        deletedNode = Integer.parseInt(br.readLine());
        // 시작 노드
        int startNode=0;
        for (int i = 0; i < T; i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            if(parentNode == -1)
                startNode = i;
            // 삭제할 노드를 애초에 트리에 넣지 않움.
            else if(parentNode != deletedNode && i != deletedNode)
                adjList[parentNode].add(i);
        }
        // 트리 각 노드 정렬
        for (int i = 0; i < T; i++) Collections.sort(adjList[i]);

        dfs(startNode);
        System.out.println(count);


    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
