import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] p = new int[N];
		int root = 0;
		ArrayList<Integer>[] tree = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());

			if (p[i] != -1)
				tree[p[i]].add(i);
			else
				root = i;
		}

		int target = Integer.parseInt(br.readLine());

		if (p[target] == -1) {
			System.out.println(0);
			return;
		}

		tree[p[target]].remove(new Integer(target));

		Queue<Integer> q = new LinkedList<>();
		int answer = 0;
		q.offer(root);

		while (!q.isEmpty()) {
			int temp = q.poll();

			if (tree[temp].size() == 0)
				answer++;

			for (int i = 0; i < tree[temp].size(); i++) {
				q.offer(tree[temp].get(i));
			}
		}

		System.out.println(answer);
	}
}
