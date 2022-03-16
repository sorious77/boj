import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int N;
    static String s1, s2;
    static String mixed;

    static class Pair {
        int idx1, idx2;

        Pair(int idx1, int idx2) {
            this.idx1 = idx1;
            this.idx2 = idx2;
        }
    }

    static void init() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            N = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void input() {
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());

            s1 = st.nextToken();
            s2 = st.nextToken();

            mixed = st.nextToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean canMakeWord() {
        int length = mixed.length();
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[s1.length() + 1][s2.length() + 1];

        q.offer(new Pair(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if (cur.idx1 + cur.idx2 >= length) {
                return true;
            }

            char m = mixed.charAt(cur.idx1 + cur.idx2);

            if (cur.idx1 < s1.length()) {
                char c1 = s1.charAt(cur.idx1);

                if (c1 == m && !visited[cur.idx1 + 1][cur.idx2]) {
                    q.offer(new Pair(cur.idx1 + 1, cur.idx2));
                    visited[cur.idx1 + 1][cur.idx2] = true;
                }
            }

            if (cur.idx2 < s2.length()) {
                char c2 = s2.charAt(cur.idx2);

                if (c2 == m && !visited[cur.idx1][cur.idx2 + 1]) {
                    q.offer(new Pair(cur.idx1, cur.idx2 + 1));
                    visited[cur.idx1][cur.idx2 + 1] = true;
                }
            }
        }

        return false;
    }

    static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            input();

            sb.append("Data set ").append(i).append(": ");

            sb.append(canMakeWord() ? "yes\n" : "no\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        init();

        solve();
    }
}

