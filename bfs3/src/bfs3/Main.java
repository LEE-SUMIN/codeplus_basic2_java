package bfs3;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int S;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			S = Integer.parseInt(br.readLine());
			
			int time = bfs();
			System.out.println(time);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[][] check = new int[2000][2000]; //check[display][clipboard]
		int cur_d = 1;
		int cur_c = 0;
		check[cur_d][cur_c] = 1;
		queue.add(cur_d); //d
		queue.add(cur_c); //c
		while(!queue.isEmpty()) {
			cur_d = queue.remove();
			cur_c = queue.remove();
			if(cur_d == S) {
				return check[cur_d][cur_c] - 1;
			}
			if(cur_d > 0 && check[cur_d - 1][cur_c] == 0) { //삭제
				queue.add(cur_d - 1);
				queue.add(cur_c);
				check[cur_d - 1][cur_c] = check[cur_d][cur_c] + 1;
			}
			if(cur_d != 0 && check[cur_d][cur_d] == 0) { //복사
				queue.add(cur_d);
				queue.add(cur_d);
				check[cur_d][cur_d] = check[cur_d][cur_c] + 1;
			}
			if(cur_c != 0 && cur_d + cur_c < 2 * S + 1 && check[cur_d + cur_c][cur_c] == 0) { //붙여넣기
				queue.add(cur_d + cur_c);
				queue.add(cur_c);
				check[cur_d + cur_c][cur_c] = check[cur_d][cur_c] + 1;
			}
		}
		return -1;
	}
}