package tree3;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer>[] tree;
	static int[] parent;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			tree = (ArrayList<Integer>[]) new ArrayList[N];
			parent = new int[N];
			for(int i = 0; i < N; i++) {
				tree[i] = new ArrayList<Integer>();
			}
			for(int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken()) - 1;
				int n2 = Integer.parseInt(st.nextToken()) - 1;
				tree[n1].add(n2);
				tree[n2].add(n1);
			}
			
			find(0);
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void find(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] check = new boolean[N];
		queue.add(start);
		parent[start] = -1;
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			for(int i = 0; i < tree[cur].size(); i++) {
				int next = tree[cur].get(i);
				if(check[next])
					continue;
				parent[next] = cur;
				check[next] = true;
				queue.add(next);
			}
		}
		
		for(int i = 1; i < N; i++) {
			sb.append(parent[i] + 1).append('\n');
		}
		
	}

}
