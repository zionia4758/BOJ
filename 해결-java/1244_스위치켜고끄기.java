
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Hw1_1244{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] swtichList = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = Integer.parseInt(sc.nextLine());
        int gender, idx;
        for(int k = 0; k< n; k++){
            gender = sc.nextInt();
            idx = sc.nextInt();
            sc.nextLine();
            switch (gender) {
                case 1:
                    for(int i = idx-1; i<swtichList.length;i+=idx){
                        swtichList[i] ^= 1;
                    }
                    break;
                case 2:
                    idx --;
                    swtichList[idx] ^= 1;
                    for(int move=1; (move+idx < swtichList.length)&&(idx-move>=0); move++){
                        if(swtichList[move+idx] != swtichList[idx-move]) break;
                        swtichList[idx+move] ^= 1;
                        swtichList[idx-move] ^= 1;
                    }
                    break;

                default:
                    break;
                }
            }
            for(int i=0; i<swtichList.length; ){
                for(int j =0 ;j<20;j++){
                    if(i==swtichList.length) break;
                    System.out.print(swtichList[i]+" ");
                    i++;
                }
                System.out.println();
            }
        sc.close();
    }
}
