package day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		int n,m,sx,sy,ex,ey;
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		int[][] nums = new int[n+1][n+1];
		for(int y=1; y<=n;y++) {
			token = new StringTokenizer(bf.readLine());
			for(int x=1; x<=n; x++) {
				nums[y][x] = Integer.parseInt(token.nextToken()) + nums[y][x-1];
			}
		}
		for(int x=1; x<=n;x++) {
			for(int y=1; y<=n; y++) {
				nums[y][x] = nums[y][x] + nums[y-1][x];
			}
		}
		for(int i=0; i<m; i++) {
			token = new StringTokenizer(bf.readLine());
			sy = Integer.parseInt(token.nextToken());
			sx = Integer.parseInt(token.nextToken());
			ey = Integer.parseInt(token.nextToken());
			ex = Integer.parseInt(token.nextToken());
			bw.write(new StringBuilder().append(nums[ey][ex]+nums[sy-1][sx-1]-nums[sy-1][ex]-nums[ey][sx-1]).append('\n').toString());
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
