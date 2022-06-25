import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair {
        Hole h;
        int i;
        int move;

        Pair(Hole h, int i, int move) {
            this.h = h;
            this.i = i;
            this.move = move;
        }
    }

    static class Hole implements Comparable<Hole> {
        int x, y;

        Hole(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Hole o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }

            return this.y - o.y;
        }
    }

    static int N;
    static int T;
    static Hole[] holes;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            holes = new Hole[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                holes[i] = new Hole(x, y);
            }

            Arrays.sort(holes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[N];

        q.offer(new Pair(new Hole(0, 0), -1, 0));

        int answer = -1;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            Hole h = cur.h;

            if (h.y == T) {
                answer = cur.move;
                break;
            }

            for (int i = cur.i - 1; i >= 0; i--) {
                if (Math.abs(h.y - holes[i].y) > 2) {
                    break;
                }

                if (!visited[i] && Math.abs(h.x - holes[i].x) <= 2) {
                    q.offer(new Pair(holes[i], i, cur.move + 1));
                    visited[i] = true;
                }
            }

            for (int i = cur.i + 1; i < N; i++) {
                if (Math.abs(h.y - holes[i].y) > 2) {
                    break;
                }

                if (!visited[i] && Math.abs(h.x - holes[i].x) <= 2) {
                    q.offer(new Pair(holes[i], i, cur.move + 1));
                    visited[i] = true;
                }
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}


