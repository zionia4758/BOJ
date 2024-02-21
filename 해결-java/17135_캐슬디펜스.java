
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DK_B17135 {
	static int m;
	static int n;
	static int d;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		n= Integer.parseInt(tk.nextToken());
		m = Integer.parseInt(tk.nextToken());
		d = Integer.parseInt(tk.nextToken());
		
		int[] cnt = new int[m];
		map = new int[n+1][m];
		for(int i=n; i>0; i--) {
			tk = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
//		System.out.println(Arrays.deepToString(map));
		int answer = 0;
		int[][] ranges = new int[(d+1)*(d+1)-1][2];
		int rCnt=0;
		for(int dd=1; dd<=d; dd++) {
			for(int x=-dd; x<=dd; x++) {
				ranges[rCnt++] = new int[] {x,dd-Math.abs(x)};
//				System.out.println(rCnt);
			}
			
		}
//		System.out.println(Arrays.deepToString(ranges));
		for(int a1=0; a1<m-2; a1++) {
			for(int a2=a1+1; a2<m-1; a2++) {
				for(int a3=a2+1; a3<m; a3++) {
//					System.out.println(a1+" "+a2+" "+a3);
					answer = Math.max(answer, simulation2(new int[]{a1,a2,a3}, ranges));
				}
			}
		}
		
		System.out.println(answer);
		
	}
	static int simulation2(int[] archers,int[][] priorityPos) {
		int answer = 0;
		int[][] simulationMap = new int[n+1][];
		for(int i=0; i<n+1; i++) {
			simulationMap[i] = map[i].clone();
		}
//		System.out.println(Arrays.deepToString(simulationMap));
		for(int i=0; i<n; i++) {


			for(int x: archers) {
				for(int[] direction : priorityPos) {
					
					
					int nx = x+direction[0];
					int ny = i+direction[1];
					if(archers[0]==0 && archers[1]==3 &&archers[2]==4) {

//						System.out.println(ny+ " "+nx);
					}
					if(ny<0 || nx<0 || ny>=n+1 || nx>=m) continue;
					if(simulationMap[ny][nx]==1) {
						answer++;
						simulationMap[ny][nx] = i+2;
						break;
					}else if(simulationMap[ny][nx] == i+2) {
						break;
					}
				}
			}
			simulationMap[i+1] = new int[m];
		}
//		System.out.println(Arrays.deepToString(simulationMap));
//		System.out.println(answer);
//		System.out.println();
		return answer;
	}
	static int simulation(int[] archers) {
		int answer = 0;
		int[] arrows =new int[3];
		for(int i=0; i<n; i++) {
			for(int a=0; a<3; a++) {
				if(arrows[a]<d)
					arrows[a]++;
			}
			int[] enemy = map[i].clone(); 
			int aIdx = 0;//archer idx
			for(int dd=0; dd<d; dd++){
				for(int eIdx = 0; eIdx<m; eIdx++) {
					if(enemy[eIdx]==0) continue;
					while(aIdx < 3 ) {
						if((archers[aIdx]==eIdx-dd || archers[aIdx]==eIdx+dd) && arrows[aIdx]!=0)  {
							arrows[aIdx] --;
							answer ++;
							break;
						}
						aIdx++;
					}
				}
				System.out.println(Arrays.toString(enemy));
			}
//		System.out.println();
		}
		return answer;
	}
}