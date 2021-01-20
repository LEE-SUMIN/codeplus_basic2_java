package graph1;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean found;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			A = (ArrayList<Integer>[]) new ArrayList[N];
			boolean[] check = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				A[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				A[n1].add(n2);
				A[n2].add(n1);
			}
			
			for(int i = 0; i < N; i++) {
				check[i] = true;
				go(i, 0, check);
				check[i] = false;
			}
			
			if(!found)
				System.out.println(0);
			else
				System.out.println(1);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void go(int start, int depth, boolean[] check) {
		if(found)
			return;
		if(depth == 4) {
			found = true;
			return;
		}
		for(int i = 0; i < A[start].size(); i++) {
			int next = A[start].get(i);
			if(!check[next]) {
				check[next] = true;
				go(next, depth + 1, check);
				check[next] = false;
			}
		}
		
	}
}
