
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
public class DK_B10026 {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int n = Integer.parseInt(br.readLine());
				char[][] map = new char[n][];
				char[][] map2 = new char[n][];
				for(int i=0; i<n; i++) {
					map[i] = br.readLine().toCharArray();
					map2[i] = map[i].clone();
					for(int x=0; x<n; x++) {
						if(map2[i][x] == 'G') map2[i][x] = 'R';
					}
				}
				
				Queue<int[]> queue;
				int answerRGB = 0;
				for(int y=0; y<n; y++) {
					for(int x=0; x<n; x++) {
						if(map[y][x] != 0) {
							char pivot = map[y][x];
							queue = new ArrayDeque<>();
							queue.offer(new int[] {y,x});
							answerRGB ++;
							while(!queue.isEmpty()) {
								int[] pos = queue.poll();
								int ny = pos[0];
								int nx = pos[1];
								if(nx!=0 && map[ny][nx-1]==pivot) {
									map[ny][nx-1] = 0;
									queue.offer(new int[] {ny,nx-1});
								}
								if(ny!=0 && map[ny-1][nx]==pivot) {
									map[ny-1][nx] = 0;
									queue.offer(new int[] {ny-1,nx});
								}
								if(nx!=n-1 && map[ny][nx+1]==pivot) {
									map[ny][nx+1] = 0;
									queue.offer(new int[] {ny,nx+1});
								}
								if(ny!=n-1 && map[ny+1][nx]==pivot) {
									map[ny+1][nx] = 0;
									queue.offer(new int[] {ny+1,nx});
								}
							}
						}
					}
				}
				int answerRB = 0;
				map = map2;
				for(int y=0; y<n; y++) {
					for(int x=0; x<n; x++) {
						if(map[y][x] != 0) {
							char pivot = map[y][x];
							queue = new ArrayDeque<>();
							queue.offer(new int[] {y,x});
							answerRB ++;
							while(!queue.isEmpty()) {
								int[] pos = queue.poll();
								int ny = pos[0];
								int nx = pos[1];
								if(nx!=0 && map[ny][nx-1]==pivot) {
									map[ny][nx-1] = 0;
									queue.offer(new int[] {ny,nx-1});
								}
								if(ny!=0 && map[ny-1][nx]==pivot) {
									map[ny-1][nx] = 0;
									queue.offer(new int[] {ny-1,nx});
								}
								if(nx!=n-1 && map[ny][nx+1]==pivot) {
									map[ny][nx+1] = 0;
									queue.offer(new int[] {ny,nx+1});
								}
								if(ny!=n-1 && map[ny+1][nx]==pivot) {
									map[ny+1][nx] = 0;
									queue.offer(new int[] {ny+1,nx});
								}
							}
						}
					}
				}
				System.out.println(new StringBuilder().append(answerRGB).append(' ').append(answerRB));
			}

}
