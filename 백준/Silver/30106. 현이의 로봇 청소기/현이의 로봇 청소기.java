import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private int N;
    private int M;
    private int K;
    private int[] dirX = {-1, 1, 0, 0};
    private int[] dirY = {0, 0, -1, 1};
    private int[][] map;
    private boolean[][] visited;
    private static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private void bfs(Node startNode){
        Queue<Node> que = new LinkedList<>();
        que.add(startNode);
        visited[startNode.x][startNode.y]  =true;
        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 4; i++) {
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if(rangeCheck(nowX,nowY) && !visited[nowX][nowY]){
                    int height = Math.abs(map[node.x][node.y] - map[nowX][nowY]);
                    if (height <= K) {
                        que.add(new Node(nowX, nowY));
                        visited[nowX][nowY] = true;
                    }
                }
            }
        }
    }

    private boolean rangeCheck(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }


    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    bfs(new Node(i, j));
                    count++;
                }
            }
        }
        System.out.println(count);


    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}