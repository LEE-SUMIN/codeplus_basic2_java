package graph6;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w, h;
	static int[][] map;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			String input;
			while(!(input = br.readLine()).equals("0 0")) {
				st = new StringTokenizer(input);
				w = Integer.parseInt(st.nextToken());
				h = Integer.parseInt(st.nextToken());
				map = new int[h][w];
				for(int i = 0; i < h; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j = 0; j < w; j++) {
						map[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				
				calc();
								
			}
			bw.write(sb.toString());
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void bfs(Land start) {
		Queue<Land> queue = new LinkedList<Land>();
		int start_i = start.get_i();
		int start_j = start.get_j();
		if(map[start_i][start_j] == 0) {
			return;
		}
		queue.add(start);
		map[start_i][start_j] = 0;
		while(!queue.isEmpty()) {
			Land cur = queue.remove();
			int cur_i = cur.get_i();
			int cur_j = cur.get_j();
			for(int i = 0; i < 8; i++) {
				int next_i = cur_i + dx[i];
				int next_j = cur_j + dy[i];
				if(next_i < 0 || next_j < 0 || next_i > h - 1 || next_j > w - 1)
					continue;
				if(map[next_i][next_j] == 1) {
					queue.add(new Land(next_i, next_j));
					map[next_i][next_j] = 0;
				}
			}
		}
		
	}
	
	public static void calc() {
		int count = 0;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(map[i][j] == 1) {
					bfs(new Land(i, j));
					count++;
				}
			}
		}
		sb.append(count).append('\n');
	}
}

class Land {
	private int i, j;
	
	Land(int i, int j){
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
