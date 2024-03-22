import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private ArrayList<Node> al;
    private LinkedList<Integer> [] adjList;
    private boolean [] visited;
    private int N;
    private class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString() {
            return "x: " + this.x + ", y: " + this.y;
        }
    }
    private boolean bfs(){
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        visited[0] = true;
        while(!que.isEmpty()){
            int node = que.poll();
            Iterator<Integer> it = adjList[node].listIterator();
            while(it.hasNext()){
                int nowIndex = it.next();
                if(!visited[nowIndex]){
                    que.add(nowIndex);
                    visited[nowIndex] = true;
                    if(nowIndex == N-1) return true;
                }
            }
        }
        return false;
    }

    public void run() throws Exception {
       int testCase = Integer.parseInt(br.readLine());
       for(int k=0; k<testCase; k++){
           N = Integer.parseInt(br.readLine()) + 2;
           adjList = new LinkedList[N];
           visited = new boolean[N];
           al = new ArrayList<>();
           for(int i=0; i<N; i++) adjList[i] = new LinkedList<>();

           for(int i=0; i<N; i++){
               st = new StringTokenizer(br.readLine());
               al.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
           }
           for(int i=0; i<N; i++){
               Node standardNode = al.get(i);
               for(int j=0; j<N; j++){
                    if(i != j){
                      Node nowNode = al.get(j);
                      int distance = Math.abs(nowNode.x - standardNode.x) + Math.abs(nowNode.y - standardNode.y);
                      if(distance <= 1000) adjList[i].add(j);
                    }
               }
           }
           if(bfs()) sb.append("happy\n");
           else sb.append("sad\n");
       }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}