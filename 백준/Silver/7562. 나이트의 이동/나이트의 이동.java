import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    private boolean [][] visited;
    private int [] dirX = {1, 2, 2, 1, -1, -2, -2, -1};
    private int [] dirY = {2, 1, -1, -2, -2, -1, 1, 2};
    private Node endNode;
    private int N;

    class Node{
        int x;
        int y;
        int count;
        public Node(int x, int y, int count){
            this.x= x;
            this.y = y;
            this.count =count;
        }
    }

    private void bfs(Node startNode){
        Queue<Node> que = new LinkedList<>();
        que.add(startNode);
        visited[startNode.x][startNode.y] = true;
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.x == endNode.x && node.y == endNode.y){
                if(endNode.count > node.count){
                    endNode.count = node.count;
                }
            }
            for(int i=0; i<8; i++){
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if(rangeCheck(nowX, nowY) && !visited[nowX][nowY]){
                    que.add(new Node(nowX, nowY, node.count+1));
                    visited[nowX][nowY] = true;
                }
            }

        }
    }

    private boolean rangeCheck(int x, int y){
        return (x>=0 && x<N && y>=0 && y<N);
    }

    public void run() throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            endNode = new Node(endX, endY, N*N);

            bfs(new Node(startX, startY, 0));

            sb.append(endNode.count + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}