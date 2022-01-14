import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {
        String text = input();

        int length = text.length();

        int sad = 0;
        int happy = 0;

        for (int i = 0; i < length - 2; i++) {
            String s = text.substring(i, i + 3);

            if (s.equals(":-)")) {
                happy++;
            } else if (s.equals(":-(")) {
                sad++;
            }
        }

        if (sad == happy) {
            if (sad == 0) {
                System.out.println("none");
            } else {
                System.out.println("unsure");
            }
        } else {
            if (sad > happy) {
                System.out.println("sad");
            } else {
                System.out.println("happy");
            }
        }
    }
}
