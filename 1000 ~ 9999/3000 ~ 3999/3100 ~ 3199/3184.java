import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][] visit;
    static int R, C;
    static int leftWolf, leftSheep;

    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[R][C];
            visit = new boolean[R][C];

            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();

                for (int j = 0; j < C; j++) {
                    Pair cur = new Pair(j, i);

                    if (isSheep(cur)) {
                        leftSheep++;
                    } else if (isWolf(cur)) {
                        leftWolf++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean canMove(Pair position) {
        int x = position.x;
        int y = position.y;

        return 0 <= x && x < C && 0 <= y && y < R && map[y][x] != '#' && !visit[y][x];
    }

    static boolean isSheep(Pair position) {
        return map[position.y][position.x] == 'o';
    }

    static boolean isWolf(Pair position) {
        return map[position.y][position.x] == 'v';
    }

    static void kickOrEat(Pair position) {
        int sheep = 0;
        int wolf = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(position);
        visit[position.y][position.x] = true;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            if (isSheep(cur)) {
                sheep++;
            } else if (isWolf(cur)) {
                wolf++;
            }

            for (int i = 0; i < 4; i++) {
                Pair next = new Pair(cur.x + direction[i][0], cur.y + direction[i][1]);

                if (canMove(next)) {
                    queue.offer(next);
                    visit[next.y][next.x] = true;
                }
            }
        }

        if (sheep > wolf) {
            leftWolf -= wolf;
        } else {
            leftSheep -= sheep;
        }
    }

    static void solve() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                Pair cur = new Pair(j, i);

                if (canMove(cur)) {
                    kickOrEat(cur);
                }
            }
        }

        System.out.println(leftSheep + " " + leftWolf);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}
