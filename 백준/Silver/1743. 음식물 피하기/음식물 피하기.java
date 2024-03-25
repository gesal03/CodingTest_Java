import java.io.BufferedReader;
import java.io.IOError;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int [][] map;
    private boolean [][] visited;
    private int N;
    private int M;
    private int maxCount = 0;
    private int [] dirX = {-1,1,0,0};
    private int [] dirY = {0,0,-1,1};
    private class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private int bfs(Node startNode){
        Queue<Node> que = new LinkedList<>();
        que.add(startNode);
        visited[startNode.x][startNode.y] = true;
        int count = 1;
        while(!que.isEmpty()){
            Node node = que.poll();
            for(int i=0; i<4; i++){
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if(rangeCheck(nowX, nowY) && !visited[nowX][nowY] && map[nowX][nowY] == 1){
                    que.add(new Node(nowX, nowY));
                    visited[nowX][nowY] = true;
                    count++;
                }
            }
        }
        return count;
    }
    private boolean rangeCheck(int x, int y){
        return (x>=0 && x<N && y>=0 && y<M);
    }




    public void run() throws Exception {
       st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       int K = Integer.parseInt(st.nextToken());

       map = new int[N][M];
       visited = new boolean[N][M];

       for(int i=0; i<N; i++){
           for(int j=0; j<M; j++) map[i][j] = 0;
       }
       for(int i=0; i<K; i++){
           st = new StringTokenizer(br.readLine());
           int x = Integer.parseInt(st.nextToken())-1;
           int y = Integer.parseInt(st.nextToken())-1;
           map[x][y] = 1;
       }
       for(int i=0; i<N; i++){
           for(int j=0; j<M; j++){
               if(!visited[i][j] && map[i][j]==1){
                   int count = bfs(new Node(i, j));
                   if(maxCount < count) maxCount = count;
               }
           }
       }
       System.out.println(maxCount);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}