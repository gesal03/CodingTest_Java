import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.module.FindException;
import java.sql.Array;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private StringBuilder sb = new StringBuilder();

    private int sum = 0;

    // BFS
    private void bfsList(int v, LinkedList<Integer> [] adjList, boolean [] visited){
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true;
        queue.add(v);
        while(queue.size() != 0){
            v = queue.poll();
            Iterator<Integer> it = adjList[v].listIterator();
            while(it.hasNext()){
                int w = it.next();
                if(!visited[w]){
                    sum++;
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }


    public  void run() throws Exception {
        int n = Integer.parseInt(br.readLine()); // node count
        int m = Integer.parseInt(br.readLine());

        boolean [] visited = new boolean[n+1];
        LinkedList<Integer> [] adjList = new LinkedList[n+1];

        for(int i=0; i<=n; i++){
            adjList[i] = new LinkedList<Integer>();
        }

        // 간선 쌍 삽입
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        // 작은 값 부터 탐색을 위한 오름차순 정렬
        for(int i=0; i<=n; i++){
            Collections.sort(adjList[i]);
        }
        bfsList(1, adjList, visited);
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}