package graph5;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
	static int[][] map;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			calc();
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int bfs(House start) {
		Queue<House> queue = new LinkedList<House>();
		int i = start.get_i();
		int j = start.get_j();
		queue.add(new House(i, j));
		map[i][j] = 0;
		int count = 1;
		while(!queue.isEmpty()) {
			House cur = queue.remove();
			int cur_i = cur.get_i();
			int cur_j = cur.get_j();
			if(cur_j < N - 1 && map[cur_i][cur_j + 1] == 1) {
				queue.add(new House(cur_i, cur_j + 1));
				map[cur_i][cur_j + 1] = 0;
				count++;
			}
			if(cur_j > 0 && map[cur_i][cur_j - 1] == 1) {
				queue.add(new House(cur_i, cur_j - 1));
				map[cur_i][cur_j - 1] = 0;
				count++;
			}
			if(cur_i < N - 1 && map[cur_i + 1][cur_j] == 1) {
				queue.add(new House(cur_i + 1, cur_j));
				map[cur_i + 1][cur_j] = 0;
				count++;
			}
			if(cur_i > 0 && map[cur_i - 1][cur_j] == 1) {
				queue.add(new House(cur_i - 1, cur_j));
				map[cur_i - 1][cur_j] = 0;
				count++;
			}
		}
		return count;
	}
	
	public static void calc() {
		ArrayList<Integer> num = new ArrayList<Integer>();
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					count++;
					num.add(bfs(new House(i, j)));
				}
			}
		}
		num.sort(null);
		sb.append(count);
		while(!num.isEmpty()) {
			sb.append('\n').append(num.remove(0));
		}
	}
}

class House {
	int i, j;
	
	House(int i, int j){
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
