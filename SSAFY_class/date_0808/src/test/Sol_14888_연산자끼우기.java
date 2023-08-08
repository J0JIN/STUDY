package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.Operation;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Sol_14888_연산자끼우기 {

	static int N;
	static int[] operator = new int[4];
	static int[] op;
	static Queue<Integer> arr;
	static int x, y;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		String[] input01 = br.readLine().split(" ");
		String[] input02 = br.readLine().split(" ");

		arr = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(input01[i]));
		}

		op = new int[N - 1];

		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(input02[i]);
		}
		
		comb(0,0);
		System.out.println(max);
		System.out.println(min);

	}

	public static void comb(int idx, int count) {
		if(count == N-1) {
			Queue<Integer> tmp = new LinkedList<>(arr);
			x = tmp.poll();
			
			for(int i = 0; i < N - 1; i++) {
				switch (op[i]) {
				case 1:
					y = tmp.poll();
					x += y;
					break;
				case 2:
					y = tmp.poll();
					x -= y;
					break;

				case 3:
					y = tmp.poll();
					x *= y;
					break;
				case 4:
					y = tmp.poll();
					x /= y;
					break;
				}
			}
			max = Math.max(x, max);
			min = Math.min(x, min);
			return;
		}
		if(idx == N-1) {
			return;
		}

		if (operator[0] > 0) {
			operator[0]--;
			op[idx] = 1;
			comb(idx + 1, count + 1);
			
			op[idx] = 0;
			operator[0]++;
			comb(idx + 1, count);
		} 
		
		if (operator[1] > 0) {
			operator[1]--;
			op[idx] = 2;
			comb(idx + 1, count + 1);
			
			operator[1]++;
			op[idx] = 0;
			comb(idx + 1, count);
		}
		
		if (operator[2] > 0) {
			operator[2]--;
			op[idx] = 3;
			comb(idx + 1, count + 1);
			
			operator[2]++;
			op[idx] = 0;
			comb(idx + 1, count);
		} 
		
		if (operator[3] > 0) {
			operator[3]--;
			op[idx] = 4;
			comb(idx + 1, count + 1);
			
			operator[3]++;
			op[idx] = 0;
			comb(idx + 1, count);
		}

	}

}
