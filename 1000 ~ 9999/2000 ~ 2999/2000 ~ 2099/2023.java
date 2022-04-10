import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N;
    static int MAX_VALUE;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            MAX_VALUE = (int) Math.pow(10, N);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean isPrime(int n) {
        for (int i = 3; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    static void solve() {
        List<List<Integer>> nthPrimes = new ArrayList<>();

        nthPrimes.add(new ArrayList<>() {
            {
                add(2);
                add(3);
                add(5);
                add(7);
            }
        });

        for (int i = 2; i <= N; i++) {
            List<Integer> ithPrime = new ArrayList<>();

            for (int prime : nthPrimes.get(i - 2)) {
                for (int j = 1; j < 10; j += 2) {
                    int nextPrime = prime * 10 + j;

                    if (isPrime(nextPrime)) {
                        ithPrime.add(nextPrime);
                    }
                }
            }

            nthPrimes.add(ithPrime);
        }

        StringBuilder sb = new StringBuilder();
        for (int prime : nthPrimes.get(N - 1)) {
            sb.append(prime).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

