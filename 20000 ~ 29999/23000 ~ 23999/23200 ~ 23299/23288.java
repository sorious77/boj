import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int EAST = 0;
    private static final int SOUTH = 1;
    private static final int WEST = 2;
    private static final int NORTH = 3;

    static int N, M, K;
    static int[][] map;
    static int[][] score;

    static int direction = EAST;
    static int tile;

    static int ceil, top, right;
    static int x, y;

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void bfs(int x, int y) {
        int tile = map[y][x];

        ArrayList<Pair> list = new ArrayList<>();

        boolean[][] isVisit = new boolean[N][M];
        Queue<Pair> q = new LinkedList<>();

        int count = 1;
        q.offer(new Pair(x, y));
        isVisit[y][x] = true;
        list.add(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if (canMove(cur.x - 1, cur.y, isVisit, tile)) {
                q.offer(new Pair(cur.x - 1, cur.y));
                count++;
                isVisit[cur.y][cur.x - 1] = true;
                list.add(new Pair(cur.x - 1, cur.y));
            }

            if (canMove(cur.x + 1, cur.y, isVisit, tile)) {
                q.offer(new Pair(cur.x + 1, cur.y));
                count++;
                isVisit[cur.y][cur.x + 1] = true;
                list.add(new Pair(cur.x + 1, cur.y));
            }

            if (canMove(cur.x, cur.y - 1, isVisit, tile)) {
                q.offer(new Pair(cur.x, cur.y - 1));
                count++;
                isVisit[cur.y - 1][cur.x] = true;
                list.add(new Pair(cur.x, cur.y - 1));
            }

            if (canMove(cur.x, cur.y + 1, isVisit, tile)) {
                q.offer(new Pair(cur.x, cur.y + 1));
                count++;
                isVisit[cur.y + 1][cur.x] = true;
                list.add(new Pair(cur.x, cur.y + 1));
            }
        }

        for (Pair p : list) {
            score[p.y][p.x] = count * tile;
        }
    }

    static boolean canMove(int x, int y, boolean[][] isVisit, int tile) {
        if (0 <= x && x < M && 0 <= y && y < N && !isVisit[y][x] && map[y][x] == tile)
            return true;

        return false;
    }

    static void init() {
        x = y = 0;

        ceil = 1;
        top = 2;
        right = 3;

        score = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (score[i][j] == 0) {
                    bfs(j, i);
                }
            }
        }
    }

    static void solve() {
        int answer = 0;

        for (int i = 0; i < K; i++) {
            answer += move();
        }

        System.out.println(answer);
    }

    static void canRoll() {
        switch (direction) {
            case EAST:
                if (x + 1 >= M)
                    direction = WEST;
                break;
            case WEST:
                if (x - 1 < 0)
                    direction = EAST;
                break;
            case NORTH:
                if (y - 1 < 0)
                    direction = SOUTH;
                break;
            case SOUTH:
                if (y + 1 >= N)
                    direction = NORTH;
                break;
        }
    }

    static void roll() {
        canRoll();

        int temp = ceil;

        switch (direction) {
            case EAST:
                ceil = 7 - right;
                right = temp;
                x += 1;
                break;
            case WEST:
                ceil = right;
                right = 7 - temp;
                x -= 1;
                break;
            case NORTH:
                ceil = 7 - top;
                top = temp;
                y -= 1;
                break;
            case SOUTH:
                ceil = top;
                top = 7 - temp;
                y += 1;
                break;
        }
    }

    static int move() {
        roll();

        int floor = 7 - ceil;
        tile = map[y][x];

        if (floor > tile) {
            direction = (direction + 1) % 4;
        } else if (floor < tile) {
            direction = (direction + 3) % 4;
        }

        return score[y][x];
    }

    public static void main(String[] args) {
        input();
        init();
        solve();
    }
}
