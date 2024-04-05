import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private final int[] dirX = {-1, 1, 0, 0};
    private final int[] dirY = {0, 0, -1, 1};
    private int N;
    private int M;
    private int[][] map;
    private boolean[][] visited;
    private boolean[] footprint;
    private int maxCount = 0;

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void dfs(Node node, int count) {
        if(maxCount < count) maxCount = count;
        visited[node.x][node.y] = true;
        footprint[map[node.x][node.y]] = true;
        for (int i = 0; i < 4; i++) {
            int nowX = node.x + dirX[i];
            int nowY = node.y + dirY[i];
            if (rangeCheck(nowX, nowY) && !visited[nowX][nowY] && !footprint[map[nowX][nowY]]) {
                int nowCount = count+1;
//                System.out.println("(" + node.x + "," + node.y + ") " + map[node.x][node.y] + " : " + count + " -> (" + nowX + "," + nowY + ") " + map[nowX][nowY] + " : " + nowCount);
                visited[nowX][nowY] = true;
                footprint[map[nowX][nowY]] = true;
                dfs(new Node(nowX, nowY), nowCount);
                visited[nowX][nowY] = false;
                footprint[map[nowX][nowY]] = false;
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

        map = new int[N][M];
        visited = new boolean[N][M];
        footprint = new boolean[91];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        dfs(new Node(0, 0), 1);
        System.out.println(maxCount);

    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}