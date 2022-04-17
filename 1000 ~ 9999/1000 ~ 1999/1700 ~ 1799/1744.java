import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[] numbers;
    static PriorityQueue<Integer> positivePq;
    static PriorityQueue<Integer> negativePq;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            numbers = new int[N];
            positivePq = new PriorityQueue<>(Collections.reverseOrder());
            negativePq = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(br.readLine());

                if (numbers[i] > 0) {
                    positivePq.offer(numbers[i]);
                } else {
                    negativePq.offer(numbers[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        int answer = 0;

        while (!positivePq.isEmpty() && positivePq.size() >= 2) {
            int n1 = positivePq.poll();
            int n2 = positivePq.poll();

            if (n1 * n2 > n1 + n2) {
                answer += n1 * n2;
            } else {
                answer += n1;
                positivePq.offer(n2);
            }
        }

        while (!negativePq.isEmpty() && negativePq.size() >= 2) {
            int n1 = negativePq.poll();
            int n2 = negativePq.poll();

            if (n1 * n2 > n1 + n2) {
                answer += n1 * n2;
            } else {
                answer += n1;
                negativePq.offer(n2);
            }
        }

        if (!positivePq.isEmpty() && !negativePq.isEmpty()) {
            int n1 = positivePq.poll();
            int n2 = negativePq.poll();

            answer += Math.max(n1 + n2, n1 * n2);
        } else if (!positivePq.isEmpty()) {
            answer += positivePq.poll();
        } else if (!negativePq.isEmpty()) {
            answer += negativePq.poll();
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

