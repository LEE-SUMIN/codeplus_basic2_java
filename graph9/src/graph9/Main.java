package graph9;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int I;
	static int[][] chess;
	static int to_i, to_j;
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		try {
			int N = Integer.parseInt(br.readLine());
			while(N --> 0) {
				I = Integer.parseInt(br.readLine());
				chess = new int[I][I];
				
				st = new StringTokenizer(br.readLine());
				int from_i = Integer.parseInt(st.nextToken());
				int from_j = Integer.parseInt(st.nextToken());
				Knight from = new Knight(from_i, from_j);
				
				st = new StringTokenizer(br.readLine());
				to_i = Integer.parseInt(st.nextToken());
				to_j = Integer.parseInt(st.nextToken());
				
				int num = bfs(from);	
				sb.append(num).append('\n');
			}
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int bfs(Knight start) {
		Queue<Knight> queue = new LinkedList<Knight>();
		queue.add(start);
		chess[start.get_i()][start.get_j()] = 1;
		while(!queue.isEmpty()) {
			Knight cur = queue.remove();
			int cur_i = cur.get_i();
			int cur_j = cur.get_j();
			if(cur_i == to_i && cur_j == to_j) {
				return chess[cur_i][cur_j] - 1;
			}
			for(int i = 0; i < 8; i++) {
				int next_i = cur_i + dx[i];
				int next_j = cur_j + dy[i];
				if(next_i < 0 || next_j < 0 || next_i > I - 1 || next_j > I - 1)
					continue;
				if(chess[next_i][next_j] == 0) {
					queue.add(new Knight(next_i, next_j));
					chess[next_i][next_j] = chess[cur_i][cur_j] + 1;
				}
			}
		}
		return -1;
	}
}

class Knight {
	private int i, j;
	
	Knight(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public int get_i() {
		return i;
	}
	
	public int get_j() {
		return j;
	}
}
