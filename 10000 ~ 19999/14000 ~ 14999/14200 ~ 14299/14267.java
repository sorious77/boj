import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> employees;
    static int[] compliments;
    static int root;

    static class Pair {
        int e, w;

        Pair(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            compliments = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            employees = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                employees.add(new ArrayList<>());
            }

            for (int i = 1; i <= N; i++) {
                int boss = Integer.parseInt(st.nextToken());

                if (boss != -1) {
                    employees.get(boss).add(i);
                } else {
                    root = i;
                }
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                compliments[e] += w;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        int[] answer = new int[N + 1];

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, compliments[root]));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int e = cur.e;
            int w = cur.w;

            answer[e] = compliments[e] + w;

            for (int employee : employees.get(e)) {
                q.offer(new Pair(employee, w + compliments[e]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i] + " ");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}
