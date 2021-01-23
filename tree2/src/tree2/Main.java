package tree2;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static Node[] nodes;
	static int o = 1;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			nodes = new Node[N];
			boolean[] root = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken()) - 1;
				int left = Integer.parseInt(st.nextToken()) - 1;
				int right = Integer.parseInt(st.nextToken()) - 1;
				
				nodes[n] = new Node(left, right);
				
				if(left >= 0) {
					root[left] = true;
				}
				if(right >= 0) {
					root[right] = true;
				}
			}
			
			for(int i = 0; i < N; i++) {
				if(!root[i]) {
					inorder(nodes[i], 1);
					result(N);
					break;
				}
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void inorder(Node start, int depth) {
		if(start.left >= 0) {
			inorder(nodes[start.left], depth + 1);
		}
		start.depth = depth;
		start.order = o;
		o++;
		if(start.right >= 0) {
			inorder(nodes[start.right], depth + 1);
		}
	}
	
	public static void result(int N) {
		int lev = 0;
		int[] left = new int[N + 1];
		int[] right = new int[N + 1];
		for(int i = 0; i < N; i++) {
			int depth = nodes[i].depth;
			int order = nodes[i].order;
			if(left[depth] == 0) {
				left[depth] = order;
			}
			else {
				left[depth] = left[depth] > order ? order : left[depth];
			}
			right[depth] = right[depth] > order ? right[depth] : order;
			lev = Math.max(lev, depth);
		}
		
		int max_len = 1;
		int max_lev = 1;
		for(int i = 1; i <= lev; i++) {
			int len = right[i] - left[i] + 1;
			if(max_len < len) {
				max_len = len;
				max_lev = i;
			}
		}
		
		System.out.println(max_lev + " " + max_len);
	}
}

class Node {
	int left, right = 0;
	int depth;
	int order;
	Node(int left, int right){
		this.left = left;
		this.right = right;
	}
}