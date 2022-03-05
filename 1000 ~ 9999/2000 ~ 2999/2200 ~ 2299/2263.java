import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] inorder;
    static int[] postorder;
    static StringBuilder sb;
    static Map<Integer, Integer> map;
    
    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            inorder = new int[N];
            postorder = new int[N];

            StringTokenizer in = new StringTokenizer(br.readLine());
            StringTokenizer post = new StringTokenizer(br.readLine());

            map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                inorder[i] = Integer.parseInt(in.nextToken());
                postorder[i] = Integer.parseInt(post.nextToken());
                map.put(inorder[i], i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void makeTree(int inStart, int inEnd, int postStart, int postEnd) {
        int length = inEnd - inStart + 1;

        if(length <= 0) {
            return;
        }

        int root = postorder[postEnd];

        if(length == 1) {
            sb.append(root).append(" ");

            return;
        }

        sb.append(root).append(" ");

        int rootIndex = map.get(root);

        int leftNum = rootIndex - inStart;

        makeTree(inStart, rootIndex - 1, postStart, postStart + leftNum - 1);
        makeTree(rootIndex + 1,inEnd,postStart + leftNum,postEnd - 1);
    }

    static void solve() {
        sb = new StringBuilder();

        makeTree(0, N - 1, 0, N - 1);

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}
