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
    private boolean[][] topList;
    private int[] dirX = {-1, 1, 0, 0, 1, 1, -1, -1};
    private int[] dirY = {0, 0, -1, 1, -1, 1, 1, -1};
    private int count = 0;

    private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ") -> " + map[this.x][this.y];
        }
    }

    private boolean bfs(Node startNode) {
        Queue<Node> que = new LinkedList<>();
        que.add(startNode);
        visited = new boolean[N][M];
        visited[startNode.x][startNode.y] = true;
        ArrayList<Node> al = new ArrayList<>();
        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 8; i++) {
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if (rangeCheck(nowX, nowY) && !visited[nowX][nowY]) {
                    if (map[nowX][nowY] > map[node.x][node.y]) return false;
                    else if (map[nowX][nowY] == map[node.x][node.y]) {
                        Node nowNode = new Node(nowX, nowY);
                        que.add(nowNode);
                        al.add(nowNode);
                    }
                    visited[nowX][nowY] = true;
                }
            }
        }
        Iterator<Node> it = al.listIterator();
        while (it.hasNext()) {
            Node node = it.next();
            topList[node.x][node.y] = true;
        }
        return true;
    }

    private boolean rangeCheck(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        topList = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !topList[i][j]) {
                    Node node = new Node(i, j);
                    if (bfs(node)) count++;
                }
            }
        }
        System.out.println(count);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}