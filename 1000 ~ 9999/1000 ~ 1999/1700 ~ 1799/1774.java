import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int x, y;
        double w;

        public Node(int x, int y, double w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.w, o.w);
        }
    }

    static int N, M;
    static double[][] gods;
    static PriorityQueue<Node> paths;
    static int[] parents;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            gods = new double[N + 1][2];
            paths = new PriorityQueue<>();
            parents = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());

                gods[i][0] = x;
                gods[i][1] = y;
                parents[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int g1 = Integer.parseInt(st.nextToken());
                int g2 = Integer.parseInt(st.nextToken());

                union(g1, g2);
            }

            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    paths.offer(new Node(i, j, getDistance(i, j)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        double answer = 0;

        while (!paths.isEmpty()) {
            Node cur = paths.poll();

            int g1 = cur.x;
            int g2 = cur.y;

            if (getParent(g1) == getParent(g2)) {
                continue;
            }

            answer += cur.w;

            union(g1, g2);
        }

        System.out.printf("%.2f\n", answer);
    }

    static double getDistance(int g1, int g2) {
        return Math.sqrt(Math.pow(gods[g1][0] - gods[g2][0], 2) + Math.pow(gods[g1][1] - gods[g2][1], 2));
    }

    static int getParent(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = getParent(parents[x]);
    }

    static void union(int x, int y) {
        x = getParent(x);
        y = getParent(y);

        if (x < y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

