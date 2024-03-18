import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int N;
    private int M;
    private int [][] map;
    private boolean [][] visited;
    private ArrayList<Node> startNodes = new ArrayList<>();
    private int [] dirX = {-1, 1, 0, 0};
    private int [] dirY = {0, 0, -1, 1};

    private int max = 0;

    class Node{
        int x;
        int y;
        int count;
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private void bfs(Node startNode){
        int maxCount = 0;
        Queue<Node> que = new LinkedList<>();
        que.add(startNode);
        visited[startNode.x][startNode.y] = true;
        while(!que.isEmpty()){
            Node node = que.poll();
            for(int i=0; i<4; i++){
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if(rangeCheck(nowX, nowY) && !visited[nowX][nowY] && map[nowX][nowY] == 1){
                    que.add(new Node(nowX, nowY, node.count+1));
                    visited[nowX][nowY] = true;
                    if(node.count+1 > maxCount) maxCount = node.count+1;
                }
            }
        }
        if(max < maxCount) max = maxCount;
    }
    private boolean rangeCheck(int x, int y){
        return (x>=0 && x<N && y>=0 && y<M);
    }


    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                if(str.charAt(j) == 'W') map[i][j] = 0;
                else{
                    map[i][j] = 1;
                    startNodes.add(new Node(i, j, 0));
                }
            }
        }
        Iterator<Node> it = startNodes.listIterator();
        while(it.hasNext()){
            Node startNode = it.next();
            visited = new boolean[N][M];
            bfs(startNode);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}