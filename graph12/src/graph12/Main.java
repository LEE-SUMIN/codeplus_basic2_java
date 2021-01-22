package graph12;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static ArrayList<Integer> answer;
	static ArrayList<Integer>[] edges;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			answer = new ArrayList<Integer>(N);
			edges = (ArrayList<Integer>[]) new ArrayList[N];
			int[] index = new int[N];
			boolean[] check = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				edges[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken()) - 1;
				int n2 = Integer.parseInt(st.nextToken()) - 1;
				edges[n1].add(n2);
				edges[n2].add(n1);
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int n = Integer.parseInt(st.nextToken()) - 1;
				answer.add(n);
				index[n] = i;
			}
			
			Comparator<Integer> bfsComparator= new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					if(index[o1] > index[o2]) return 1;
					else if(index[o1] < index[o2]) return -1;
					else return 0;
				}
			};
			
			for(int i = 0; i < N; i++) {
				edges[i].sort(bfsComparator);
			}
			
			if(bfs(check, answer)) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean bfs(boolean[] check, ArrayList<Integer> answer) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		check[0] = true;
		int idx = 0;
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			if(cur != answer.get(idx)) {
				return false;
			}
			idx++;
			for(int i = 0; i < edges[cur].size(); i++) {
				int next = edges[cur].get(i);
				if(!check[next]) {
					check[next] = true;
					queue.add(next);
				}
			}
		}
		return true;
	}
	

}
