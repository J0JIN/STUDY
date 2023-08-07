package date_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_2164_카드2_빡구현 {

	static class Queue {
		int MAX = 1_000_000;
		int front;
		int rear;
		int[] queue;

		public Queue() {
			this.front = 0;
			this.rear = 0;
			this.queue = new int[MAX];
		}

		public int size() {
			return rear - front;
		}

		public void offer(int val) {
			queue[rear] = val;
			rear++;
		}

		public int poll() {
			int val = queue[front];
			queue[front] = 0;
			front++;
			return val;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Queue q = new Queue();

		int cnt = 1;
		while (true) {
			if (cnt == N + 1) {
				break;
			}
			q.offer(cnt);
			cnt++;
		}

		while (q.size() > 1) {
			q.poll();
			q.offer(q.poll());
		}

		System.out.println(q.poll());
	}
}
