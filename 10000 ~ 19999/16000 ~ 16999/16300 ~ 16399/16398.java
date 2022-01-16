import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] planet;

    static boolean[] isMerged;

    static PriorityQueue<Planet> pq;

    static class Planet implements Comparable<Planet> {
        int from, to, cost;

        public Planet(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Planet o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st;

            planet = new int[N][N];
            isMerged = new boolean[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    planet[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        pq = new PriorityQueue<>();

        int size = 1;
        isMerged[0] = true;
        insertToPq(0);

        long answer = 0;

        while (size < N) {
            Planet p = pq.poll();

            if(!isMerged[p.to]) {
                answer += p.cost;
                isMerged[p.to] = true;

                insertToPq(p.to);
                size++;
            }
        }

        System.out.println(answer);
    }

    static void insertToPq(int x) {
        for (int i = 0; i < N; i++) {
            if (i != x) {
                pq.offer(new Planet(x, i, planet[x][i]));
            }
        }
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}
