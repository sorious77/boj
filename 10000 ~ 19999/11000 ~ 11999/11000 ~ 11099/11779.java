import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Pair implements Comparable<Pair> {
        int e;
        long w;

        Pair(int e, long w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Pair o) {
            return (int) (this.w - o.w);
        }
    }

    static int INF;

    static int N, M;
    static int[][] graph;
    static int start, end;
    static int[] parent;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            INF = N * 100000 + 1;

            graph = new int[N + 1][N + 1];
            parent = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                Arrays.fill(graph[i], INF);
                graph[i][i] = 0;
            }

            StringTokenizer st;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                if (graph[s][e] > w) {
                    graph[s][e] = w;
                }
            }

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void dijkstra() {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (i != start) {
                pq.offer(new Pair(i, graph[start][i]));
                parent[i] = start;
            }
        }

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (graph[start][cur.e] < cur.w) {
                continue;
            }

            for (int i = 1; i <= N; i++) {
                if (graph[start][i] > graph[start][cur.e] + graph[cur.e][i]) {
                    graph[start][i] = graph[start][cur.e] + graph[cur.e][i];
                    parent[i] = cur.e;

                    pq.offer(new Pair(i, graph[start][i]));
                }
            }
        }
    }

    static void solve() {
        dijkstra();

        StringBuilder sb = new StringBuilder();

        sb.append(graph[start][end]).append("\n");

        Stack<Integer> st = new Stack<>();

        while (true) {
            st.push(end);

            if (start == end) {
                break;
            }

            end = parent[end];
        }
        sb.append(st.size()).append("\n");

        while (!st.isEmpty()) {
            sb.append(st.pop()).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

