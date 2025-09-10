import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 N은 수의 개수 M은 수의 변경 횟수 K는 구간합 1은 숫자 업데이트 2는 구간 합 출력
 */
public class Main {

	static class SegmentTree {
		long[] arr;
		long[] tree;

		public SegmentTree(long[] inputArray) {
			this.arr = inputArray;
			int n = arr.length;
			// 넉넉하게 4N만큼의 메모리 공간 생성
			this.tree = new long[4 * n];
			build(1, 1, n - 1);
		}

		public void build(int node, int start, int end) {
			if (start == end) {
				tree[node] = arr[start];
			} else {
				int mid = (start + end) / 2;
				build(2 * node, start, mid);
				build(2 * node + 1, mid + 1, end);

				tree[node] = tree[2 * node] + tree[2 * node + 1];
			}
		}

		public long query(int l, long r) {
			return query(1, 1, arr.length - 1, l, r);
		}

		private long query(int node, int start, int end, int l, long r) {
			// 완전 미포함
			if (r < start || end < l) {
				// 항등원
				return 0;
			}

			// 포함
			if (l <= start && end <= r) {
				// 구간합 리턴
				return tree[node];
			}

			// 부분 포함
			int mid = (start + end) / 2;
			// 재귀호출
			long p1 = query(2 * node, start, mid, l, r);
			long p2 = query(2 * node + 1, mid + 1, end, l, r);

			return p1 + p2;
		}

		public void update(int idx, long val) {
			update(1, 1, arr.length - 1, idx, val);
		}

		private void update(int node, int start, int end, int idx, long val) {
			// 리프 노드 도달
			if (start == end) {
				arr[idx] = val;
				tree[node] = val;
				return;
			}
			
			// 재귀 호출
			// 업데이트할 인덱스가 포함된 자식으로 이동
			int mid = (start + end) / 2;
			if (start <= idx && idx <= mid) {
				update(2 * node, start, mid, idx, val);
			} else {
				update(2 * node + 1, mid + 1, end, idx, val);
			}

			tree[node] = tree[2 * node] + tree[2 * node + 1];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[] arr = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		// build도 알아서 됨
		SegmentTree tr = new SegmentTree(arr);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			// 1은 변경(b -> c) 2는 구간합(b ~ c)
			if (a == 1) {
				tr.update(b, c);
			} else if (a == 2) {
				System.out.println(tr.query(b, c));
			}
		}

	}
}
