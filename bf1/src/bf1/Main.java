package bf1;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> dwarf = new ArrayList<>();
		int sum = 0;
		
		try {
			for(int i = 0; i < 9; i++) {
				dwarf.add(Integer.parseInt(br.readLine()));
				sum += dwarf.get(dwarf.size() - 1);
			}
			
			for(int i = 0; i < 8; i++) {
				sum -= dwarf.get(i);
				for(int j = i + 1; j < 9; j++) {
					sum -= dwarf.get(j);
					if(sum == 100) {
						dwarf.set(i, 0);
						dwarf.set(j, 0);
						break;
					}
					sum += dwarf.get(j);
				}
				sum += dwarf.get(i);
			}
			
			Collections.sort(dwarf);
			
			for(int i : dwarf) {
				sb.append(i).append('\n');
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

}
