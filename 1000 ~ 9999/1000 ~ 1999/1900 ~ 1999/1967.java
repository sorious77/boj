import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] visit;
	static TreeNode[] node;

	static class Node {
		int v; // vertex
		int w; // weight

		Node() {
		}

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static class TreeNode {
		ArrayList<Node> list = new ArrayList<>();
	}

	static class Reader {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() throws Exception {
			while (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
	}

	public static Node findMaxDist(int nodeNum) {
		Queue<Node> q = new LinkedList<>();
		int num = 0;
		int maxDist = 0;

		q.offer(new Node(nodeNum, 0));
		visit = new boolean[N + 1];
		visit[nodeNum] = true;

		while (!q.isEmpty()) {
			Node temp = q.poll();

			if (maxDist < temp.w) {
				num = temp.v;
				maxDist = temp.w;
			}

			for (int i = 0; i < node[temp.v].list.size(); i++) {
				Node next = node[temp.v].list.get(i);

				if (!visit[next.v]) {
					visit[next.v] = true;
					q.offer(new Node(next.v, temp.w + next.w));
				}
			}
		}

		return new Node(num, maxDist);
	}

	public static void main(String[] args) throws Exception {
		Reader sc = new Reader();
		int s, e, w;

		N = sc.nextInt();

		node = new TreeNode[N + 1];

		for (int i = 0; i <= N; i++) {
			node[i] = new TreeNode();
		}

		for (int i = 0; i < N - 1; i++) {
			s = sc.nextInt();
			e = sc.nextInt();
			w = sc.nextInt();

			node[s].list.add(new Node(e, w));
			node[e].list.add(new Node(s, w));
		}

		System.out.println(findMaxDist(findMaxDist(1).v).w);
	}
}
