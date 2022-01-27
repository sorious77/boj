import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            int bestSellerCount = 0;
            String bestSeller = "";

            Map<String, Integer> bookCount = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String book = br.readLine();

                int count = bookCount.getOrDefault(book, 0) + 1;

                bookCount.put(book, count);

                if (count == bestSellerCount)
                    bestSeller = bestSeller.compareTo(book) > 0 ? book : bestSeller;
                else if (count > bestSellerCount) {
                    bestSeller = book;
                    bestSellerCount = count;
                }
            }

            System.out.println(bestSeller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
