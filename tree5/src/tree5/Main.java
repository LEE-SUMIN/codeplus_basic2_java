package tree5;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Edge>[] tree;
	static int N;
	static int[] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			N = Integer.parseInt(br.readLine());
			tree = (ArrayList<Edge>[]) new ArrayList[N];
			d = new int[N];
			for(int i = 0; i < N; i++) {
				tree[i] = new ArrayList<Edge>();
			}
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				while(true) {
					int to = Integer.parseInt(st.nextToken()) - 1;
					if(to < 0) {
						break;
					}
					int d = Integer.parseInt(st.nextToken());
					tree[from].add(new Edge(to, d));
				}
			}
			
			bfs(0);
			int from = 0;
			for(int i = 1; i < N; i++) {
				from = d[from] < d[i] ? i : from;
			}
			
			d = new int[N];
			bfs(from);
			
			int diameter = 0;
			for(int i = 0; i < N; i++) {
				diameter = diameter < d[i] ? d[i] : diameter;
			}
			
			System.out.println(diameter);
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] check = new boolean[N];
		queue.add(start);
		check[start] = true;
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			for(Edge e : tree[cur]) {
				int next = e.to;
				if(check[next])
					continue;
				d[next] = d[cur] + e.d;
				check[next] = true;
				queue.add(next);
			}
		}
	}
}

class Edge {
	int to;
	int d;
	Edge(int to, int d){
		this.to = to;
		this.d = d;
	}
}
