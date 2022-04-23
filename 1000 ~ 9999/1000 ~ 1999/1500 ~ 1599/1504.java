import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    final static int INFINITE = 9999999;

    static class Pair implements Comparable<Pair> {
        int e;
        int w;

        Pair(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Pair p) {
            return this.w - p.w;
        }
    }

    static int N, E;
    static int V1, V2;
    static int[][] graph;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                Arrays.fill(graph[i], INFINITE);
                graph[i][i] = 0;
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[s][e] = w;
                graph[e][s] = w;
            }

            st = new StringTokenizer(br.readLine());

            V1 = Integer.parseInt(st.nextToken());
            V2 = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void dijkstra(int x) {
        // x를 기준으로 모든 정점에 대한 최단거리를 구하는 함수

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (i != x) {
                pq.offer(new Pair(i, graph[x][i]));
            }
        }

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (graph[x][cur.e] < cur.w || cur.w == INFINITE) {
                continue;
            }

            for (int i = 1; i <= N; i++) {
                if (graph[x][i] > cur.w + graph[cur.e][i]) {
                    graph[x][i] = cur.w + graph[cur.e][i];
                    graph[i][x] = cur.w + graph[cur.e][i];

                    pq.offer(new Pair(i, graph[x][i]));
                }
            }
        }
    }

    static void solve() {
        dijkstra(1);
        dijkstra(V1);
        dijkstra(V2);
        dijkstra(N);

        int answer = Math.min(graph[1][V1] + graph[V1][V2] + graph[V2][N], graph[1][V2] + graph[V2][V1] + graph[V1][N]);

        System.out.println(answer >= INFINITE ? -1 : answer);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

