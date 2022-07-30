import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int n, w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static int N, M;
    static int[][] map;
    static int[] path;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N + 1][N + 1];
            path = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                Arrays.fill(map[i], 9999999);
                map[i][i] = 0;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                map[x][y] = t;
                map[y][x] = t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        dijkstra();

        List<Node> answer = new ArrayList<>();

        boolean[] visit = new boolean[N + 1];

        for(int i = 2; i <= N; i++) {
            int parent = path[i];
            int child = i;

            if(visit[i]) {
                continue;
            }

            answer.add(new Node(parent, child));
            visit[child] = true;

            while(parent != 1 && !visit[child]) {
                if(map[parent][child] != 9999999) {
                    answer.add(new Node(parent, child));
                }

                visit[child] = true;

                child = parent;
                parent = path[parent];
            }
        }

        System.out.println(answer.size());

        for(Node n : answer) {
            System.out.println(n.n + " " + n.w);
        }
    }

    static void dijkstra() {
        int[] dist = Arrays.copyOf(map[0], N + 1);
        Arrays.fill(dist, 9999999);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.w > dist[node.n]) {
                continue;
            }

            for (int i = 2; i <= N; i++) {
                if (dist[i] > dist[node.n] + map[node.n][i]) {
                    dist[i] = dist[node.n] + map[node.n][i];
                    path[i] = node.n;
                    pq.offer(new Node(i, dist[i]));
                }
            }
        }
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

