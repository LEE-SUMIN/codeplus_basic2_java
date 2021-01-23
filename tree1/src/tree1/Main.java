package tree1;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int N;
	static int[][] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			tree = new int[N][2];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int node = st.nextToken().charAt(0) - 'A';
				for(int j = 0; j < 2; j++) {
					char ch = st.nextToken().charAt(0);
					if(ch >= 'A' && ch <= 'Z') {
						tree[node][j] = ch - 'A';
					}
				}
			}
			
			preorder(0);
			sb.append('\n');
			inorder(0);
			sb.append('\n');
			postorder(0);
			sb.append('\n');
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void preorder(int start) {
		sb.append((char)(start + 'A'));
		if(tree[start][0] != 0) {
			preorder(tree[start][0]);
		}
		if(tree[start][1] != 0) {
			preorder(tree[start][1]);
		}
	}
	
	public static void inorder(int start) {
		if(tree[start][0] != 0) {
			inorder(tree[start][0]);
		}
		sb.append((char)(start + 'A'));
		if(tree[start][1] != 0) {
			inorder(tree[start][1]);
		}
	}
	
	public static void postorder(int start) {
		if(tree[start][0] != 0) {
			postorder(tree[start][0]);
		}
		if(tree[start][1] != 0) {
			postorder(tree[start][1]);
		}
		sb.append((char)(start + 'A'));
	}

}
