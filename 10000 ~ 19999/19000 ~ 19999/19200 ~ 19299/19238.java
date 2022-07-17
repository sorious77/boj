import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            if (this.d == o.d) {
                if (this.y == o.y) {
                    return this.x - o.x;
                } else {
                    return this.y - o.y;
                }
            } else {
                return this.d - o.d;
            }
        }
    }

    static class Passenger {
        Pair from, to;

        public Passenger(Pair from, Pair to) {
            this.from = from;
            this.to = to;
        }
    }

    static int N, M;
    static int fuel;
    static int[][] map;
    static Map<Integer, Passenger> passengers;
    static Pair taxi;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            fuel = Integer.parseInt(st.nextToken());

            map = new int[N + 1][N + 1];
            passengers = new HashMap<>();

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] == 1) {
                        map[i][j] = -1;
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            taxi = new Pair(x, y);

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());

                int fromY = Integer.parseInt(st.nextToken());
                int fromX = Integer.parseInt(st.nextToken());
                int toY = Integer.parseInt(st.nextToken());
                int toX = Integer.parseInt(st.nextToken());

                passengers.put(i, new Passenger(new Pair(fromX, fromY), new Pair(toX, toY)));

                map[fromY][fromX] = i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int getDistance(Pair from, Pair to) {
        boolean[][] visited = new boolean[N + 1][N + 1];

        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(from.x, from.y, 0));
        visited[from.y][from.x] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();

            if (n.x == to.x && n.y == to.y) {
                return n.d;
            }

            for (int i = 0; i < 4; i++) {
                int nx = n.x + move[i][0];
                int ny = n.y + move[i][1];

                if (0 < nx && nx <= N && 0 < ny && ny <= N && map[ny][nx] != -1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new Node(nx, ny, n.d + 1));
                }
            }
        }

        return -1;
    }

    static Node findNextPassenger() {
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int minDist = Integer.MAX_VALUE;

        boolean[][] visit = new boolean[N + 1][N + 1];
        q.offer(new Node(taxi.x, taxi.y, 0));
        visit[taxi.y][taxi.x] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();

            if (map[n.y][n.x] >= 1) {
                if (minDist < n.d) {
                    break;
                } else {
                    minDist = n.d;
                    pq.offer(n);
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = n.x + move[i][0];
                int ny = n.y + move[i][1];

                if (1 <= nx && nx <= N && 1 <= ny && ny <= N && map[ny][nx] != -1 && !visit[ny][nx]) {
                    q.offer(new Node(nx, ny, n.d + 1));
                    visit[ny][nx] = true;
                }
            }
        }

        return pq.isEmpty() ? null : pq.poll();
    }

    static void solve() {
        while (!passengers.isEmpty()) {
            Node nextPassenger = findNextPassenger();

            if(nextPassenger == null || fuel <= nextPassenger.d) {
                break;
            }

            // 승객까지 이동한 연료 사용
            fuel -= nextPassenger.d;

            Passenger passenger = passengers.get(map[nextPassenger.y][nextPassenger.x]);

            // 택시와 승객의 목적지까지의 거리
            int distance = getDistance(passenger.from, passenger.to);

            if (distance > fuel || distance == -1) {
                break;
            }

            // 택시가 이동
            taxi = passenger.to;

            // 연료 보충
            fuel += distance;

            // 승객을 리스트에서 제거
            passengers.remove(map[nextPassenger.y][nextPassenger.x]);
            map[nextPassenger.y][nextPassenger.x] = 0;
        }

        if (passengers.size() == 0) {
            System.out.println(fuel);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}


