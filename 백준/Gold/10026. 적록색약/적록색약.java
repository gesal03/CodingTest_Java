import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    private int N;
    private int count = 0;
    private int map [][];
    private boolean visited[][];

    private int [] dirX = {-1, 1, 0, 0};
    private int [] dirY = {0, 0, -1, 1};

    class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private void bfs(Node node){
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        visited[node.x][node.y] = true;
        while(!que.isEmpty()){
            Node currentNode = que.poll();
            for(int i=0; i<4; i++){
                int currentX = currentNode.x + dirX[i];
                int currentY = currentNode.y + dirY[i];
                if(rangeCheck(currentX, currentY) && !visited[currentX][currentY] && map[node.x][node.y] == map[currentX][currentY]){
                    que.add(new Node(currentX, currentY));
                    visited[currentX][currentY] = true;
                }
            }
        }
    }

    private boolean rangeCheck(int x, int y){
        return (x>=0 && x< N && y>=0 && y<N);
    }

    public  void run() throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j);
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(new Node(i, j));
                    count++;
                }
            }
        }
        sb.append(count +" ");
        visited = new boolean[N][N];
        count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 'G'){
                    map[i][j] = 'R';
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(new Node(i, j));
                    count++;
                }
            }
        }
        sb.append(count);
        System.out.println(sb);



    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}