
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class DK_B15686 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		
		int[][] map = new int[n][n];
		List<int[]> house = new ArrayList<>();
		List<int[]> chicken = new ArrayList<>();
		for(int y=0; y<n; y++) {
			tk = new StringTokenizer(br.readLine());
			for(int x=0; x<n; x++) {
				map[y][x] = Integer.parseInt(tk.nextToken());
				if(map[y][x] == 1) house.add(new int[] {y,x});
				else if(map[y][x]==2) chicken.add(new int[] {y,x});
			}
		}
		int[] combi = new int[chicken.size()];
		for(int i=0; i<m; i++) {
			combi[chicken.size()-1-i] = 1;
		}
		int[][] cPos = new int[house.size()][chicken.size()];
		for(int c = 0; c<chicken.size(); c++) {
			for(int h=0; h<house.size(); h++) {
				int dist = Math.abs(house.get(h)[0]-chicken.get(c)[0]) + Math.abs(house.get(h)[1]-chicken.get(c)[1]);
				cPos[h][c] = dist;
			}
		}
		
		int answer = Integer.MAX_VALUE;
		do {
//			System.out.println(Arrays.toString(combi));
			int[] cScore = new int[house.size()];
			Arrays.fill(cScore, Integer.MAX_VALUE);
			for(int h=0; h<house.size(); h++) {
				for(int c=0; c<chicken.size(); c++) {
					if(combi[c]==0) continue;
					cScore[h] = Math.min(cScore[h],cPos[h][c]);
				}
			}
//			System.out.println(Arrays.toString(cScore));
			int sum = 0;
			for(int score:cScore)
				sum+=score;
			if(answer > sum)
				answer = sum;
		}while(np(combi));
		System.out.println(answer);
		
		
	}
	static boolean np(int[] result) {
		int i = result.length-1;
		while(i>0 && result[i]<=result[i-1]) i--;
		if(i==0) return false;
		
		int j=result.length-1;
		while(result[i-1]>=result[j]) j--;
		int temp = result[j];
		result[j] = result[i-1];
		result[i-1] = temp;
		
		int k = result.length-1;
		while(i<k) {
			temp = result[i];
			result[i] = result[k];
			result[k] = temp;
			i++;
			k--;
		}
		return true;
	}

}
