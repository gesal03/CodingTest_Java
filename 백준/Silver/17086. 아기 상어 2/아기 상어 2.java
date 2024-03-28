import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int N;
    private int M;
    private int[][] map;
    private boolean[][] visited;
    private int[] dirX = {-1, 1, 0, 0, -1, 1, -1, 1};
    private int[] dirY = {0, 0, -1, 1, 1, 1, -1, -1};

    private class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ") -> " + map[this.x][this.y];
        }
    }

    private int bfs(Node startNode) {
        int distance = N * M;
        Queue<Node> que = new LinkedList<>();
        que.add(startNode);
        visited[startNode.x][startNode.y] = true;
        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 8; i++) {
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if (rangeCheck(nowX, nowY) && !visited[nowX][nowY]) {
                    que.add(new Node(nowX, nowY, node.distance + 1));
                    visited[nowX][nowY] = true;
                    if (map[nowX][nowY] == 1) {
                        if (distance > node.distance+1) distance = node.distance+1;
                    }
                }
            }
        }
        return distance;
    }

    private boolean rangeCheck(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    visited = new boolean[N][M];
                    int distance = bfs(new Node(i, j, 0));
//                    System.out.println(i + ", " + j + ": " + distance);
                    if (count < distance) count = distance;
                }
            }
        }


        System.out.println(count);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}