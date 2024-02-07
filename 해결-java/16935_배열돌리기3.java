
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class DK_B16935 {
	
	static int[] subArr = {0,1,2,3};
	static int[][][] splitArr = new int[4][][];
	static int[][] tfArr = {{1,0},{0,1}};
	static int[][][] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(tk.nextToken());
		int m=Integer.parseInt(tk.nextToken());
		int r=Integer.parseInt(tk.nextToken());
		int[][] temp;
		
		int[][] arr = new int[n][m];
		for(int i=0; i<4; i++)
			splitArr[i] = new int[n/2][m/2];
		int subN = n/2;
		int subM = m/2;
		for(int y=0; y<n; y++) {
			tk = new StringTokenizer(br.readLine());
			int subY = y/subN;
			for(int x=0;x<m;x++) {
				int subX = x/subM;
				splitArr[2*subY + subX][y%subN][x%subM] = Integer.parseInt(tk.nextToken());
				arr[y][x] = splitArr[2*subY + subX][y%subN][x%subM];
			}
		}	 
		tk = new StringTokenizer(br.readLine());
		for(int i=0; i<r; i++) {
			int cmd = Integer.parseInt(tk.nextToken());
			switch(cmd) {
			case 1:
				temp = splitArr[0];
				splitArr[0] = splitArr[2];
				splitArr[2] = temp;
				temp = splitArr[1];
				splitArr[1] = splitArr[3];
				splitArr[3] = temp;
				tfArr = new int[][] {{tfArr[0][0],tfArr[0][1]},{-tfArr[1][0],-tfArr[1][1]}};
				break;
			case 2:
				temp = splitArr[0];
				splitArr[0] = splitArr[1];
				splitArr[1] = temp;
				temp = splitArr[2];
				splitArr[2] = splitArr[3];
				splitArr[3] = temp;
				tfArr = new int[][] {{-tfArr[0][0],-tfArr[0][1]},{tfArr[1][0],tfArr[1][1]}};
				break;
			case 3:
				tfArr = new int[][] {{-tfArr[1][0],-tfArr[1][1]},{tfArr[0][0],tfArr[0][1]}};
			case 5:
				temp = splitArr[3];
				splitArr[3] = splitArr[1];
				splitArr[1] = splitArr[0];
				splitArr[0] = splitArr[2];
				splitArr[2] = temp;
				break;
			case 4:
				tfArr = new int[][] {{tfArr[1][0],tfArr[1][1]},{-tfArr[0][0],-tfArr[0][1]}};
			case 6:
				temp = splitArr[0];
				splitArr[0] = splitArr[1];
				splitArr[1] = splitArr[3];
				splitArr[3] = splitArr[2];
				splitArr[2] = temp;
				break;
			}
		}
		int totalX = tfArr[0][0]*subM + tfArr[0][1]*subN;
		int totalY = tfArr[1][0]*subM + tfArr[1][1]*subN;
		int newX = Math.min(-1, totalX);
		int newY = Math.min(-1, totalY);
		totalX = Math.abs(totalX);
		totalY = Math.abs(totalY);
		answer = new int[4][totalY][totalX];

		for(int i=0; i<4; i++) {
			for(int y=0; y<subN; y++) {
				for(int x=0; x<subM; x++) {
					int nx = tfArr[0][0]*x + tfArr[0][1]*y-newX-1;
					int ny = tfArr[1][0]*x + tfArr[1][1]*y-newY-1;
					answer[i][ny][nx] = splitArr[i][y][x];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<totalY; i++){
			for(int num:answer[0][i]){
				sb.append(num).append(' ');
			}
			for(int num:answer[1][i]){
				sb.append(num).append(' ');
			}
			sb.append('\n');
		}
		for(int i=0; i<totalY; i++){
			for(int num:answer[2][i]){
				sb.append(num).append(' ');
			}
			for(int num:answer[3][i]){
				sb.append(num).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
