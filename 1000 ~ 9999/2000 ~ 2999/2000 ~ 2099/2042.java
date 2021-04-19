import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int log2(int a) {
		return (int) (Math.ceil(Math.log10(a) / Math.log10(2)));
	}
	static int N, M, K;
	static long[] tree;
	static long[] arr;

	static void makeTree(int cur, int left, int right) {

		if (left == right) {
			tree[cur] = arr[left];
			return;
		}

		int mid = (left + right) / 2;

		makeTree(cur * 2, left, mid);
		makeTree(cur * 2 + 1, mid + 1, right);

		tree[cur] = tree[cur * 2] + tree[cur * 2 + 1];
	}

	static long findSum(int cur, int start, int end, long l, long o) {
		if (end < l || o < start) {
			return 0;
		}

		if (l <= start && end <= o)
			return tree[cur];

		int mid = (start + end) / 2;

		return findSum(cur * 2, start, mid, l, o) + findSum(cur * 2 + 1, mid + 1, end, l, o);
	}

	static void updateTree(int cur, int start, int end, long l, long diff) {
		if (l < start || end < l)
			return;

		tree[cur] += diff;

		if (start != end) {
			int mid = (start + end) / 2;
			updateTree(cur * 2, start, mid, l, diff);
			updateTree(cur * 2 + 1, mid + 1, end, l, diff);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int size = ((int) (Math.pow(2, log2(N)))) * 2;

		tree = new long[size];

		makeTree(1, 0, N - 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			int op = Integer.parseInt(st.nextToken());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			if (op == 1) {
				long diff = B - arr[(int) (A - 1)];
				arr[(int) (A - 1)] = B;
				updateTree(1, 0, N - 1, A - 1, diff);
			} else {
				sb.append(findSum(1, 0, N - 1, A - 1, B - 1)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
