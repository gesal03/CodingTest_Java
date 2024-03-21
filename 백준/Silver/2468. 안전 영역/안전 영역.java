import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int N;
    private int [][] map;
    private boolean [][] visited;
    private ArrayList<Integer> heights = new ArrayList<>();
    private int count=0;
    private int [] dirX = {-1,1,0,0};
    private int [] dirY = {0,0,-1,1};
    private void bfs(Node startNode, int height){
        Queue<Node> que = new LinkedList<>();
        que.add(startNode);
        visited[startNode.x][startNode.y] = true;
        while(!que.isEmpty()){
            Node node = que.poll();
            for(int i=0; i<4; i++){
                int nowX = node.x+dirX[i];
                int nowY = node.y+dirY[i];
                if(rangeCheck(nowX, nowY) && !visited[nowX][nowY] && map[nowX][nowY] > height){
                    que.add(new Node(nowX, nowY));
                    visited[nowX][nowY] = true;
                }
            }
        }
    }
    private boolean rangeCheck(int x, int y){
        return (x>=0 && x<N && y>=0 && y<N);
    }
    private class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public void run() throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        heights.add(0);
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());;
                if(!heights.contains(map[i][j])) heights.add(map[i][j]);
            }
        }
        Collections.sort(heights);
        Iterator<Integer> it = heights.iterator();
        while(it.hasNext()){
            int height = it.next();
            int nowCount = 0;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && map[i][j] > height){
                        bfs(new Node(i,j), height);
                        nowCount++;
                    }
                }
            }
            if(count < nowCount) count = nowCount;
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}