import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    final static int MAX_POINT = 100001;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        int[] move = new int[MAX_POINT];
        int[] path = new int[MAX_POINT];

        Arrays.fill(move, 9999999);

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        move[N] = 0;
        path[N] = -1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                break;
            }

            if (cur - 1 >= 0 && move[cur - 1] > move[cur] + 1) {
                move[cur - 1] = move[cur] + 1;
                path[cur - 1] = cur;
                q.offer(cur - 1);
            }

            if (cur + 1 < MAX_POINT && move[cur + 1] > move[cur] + 1) {
                move[cur + 1] = move[cur] + 1;
                path[cur + 1] = cur;
                q.offer(cur + 1);
            }

            if (cur * 2 < MAX_POINT && move[cur * 2] > move[cur] + 1) {
                move[cur * 2] = move[cur] + 1;
                path[cur * 2] = cur;
                q.offer(cur * 2);
            }
        }

        System.out.println(move[K]);

        int location = K;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();

        while (location != -1) {
            st.push(location);
            location = path[location];
        }

        while(!st.isEmpty()) {
            sb.append(st.pop()).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

