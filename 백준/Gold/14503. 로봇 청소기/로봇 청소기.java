import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private final int NORTH = 0;
    private final int EAST = 1;
    private final int SOUTH = 2;
    private final int WEST = 3;
    private int[] dirX = {-1, 0, 1, 0};
    private int[] dirY = {0, 1, 0, -1};
    private int[][] map;
    private int N;
    private int M;

    private int cleaning(int startX, int startY, int direction) {
        int nowX = startX;
        int nowY = startY;
        int d = direction;
        int count = 0;
        while (true) {
            if (map[nowX][nowY] == 0) {
                count++;
                map[nowX][nowY] = -1;
            }
            if (isExist(nowX, nowY)) {
                for (int i = 0; i < 4; i++) {
                    d -= 1;
                    if (d < 0) d += 4;
                    int targetX = nowX + dirX[d];
                    int targetY = nowY + dirY[d];
                    if (rangeCheck(targetX, targetY) && map[targetX][targetY] == 0) {
                        nowX = targetX;
                        nowY = targetY;
//                        System.out.println("FRONT (" + nowX + "," + nowY + ")");
                        break;
                    }
                }

            } else {
                int back = (d + 2) % 4;
                nowX = nowX + dirX[back];
                nowY = nowY + dirY[back];
//                System.out.println("BACK (" + nowX + "," + nowY + ")");
                if (rangeCheck(nowX, nowY) && map[nowX][nowY] == 1) return count;
            }
        }
    }

    private boolean isExist(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nowX = x + dirX[i];
            int nowY = y + dirY[i];
            if (rangeCheck(nowX, nowY) && map[nowX][nowY] == 0) return true;
        }
        return false;
    }

    private boolean rangeCheck(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }


    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(cleaning(startX, startY, direction));


    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}