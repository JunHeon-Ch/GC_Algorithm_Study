package 기초.시뮬레이션과구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no20055 {
    public static int[] A;
    public static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int length = 2*n;

        A = new int[length];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<length; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int round = 0;
        boolean[] robot = new boolean[n];
        while(durability()){
            int temp = A[length-1];
            for(int i=length-1; i>0; i--){
                A[i] = A[i-1];
            }
            A[0] = temp;

            for(int i=n-1; i>0; i--){
                robot[i] = robot[i-1];
            }
            robot[0] = false;
            robot[n-1] = false;

            for(int i=n-1; i>0; i--){
                if(!robot[i] && robot[i-1] && A[i] >=1){
                    robot[i] = true;
                    robot[i-1] = false;
                    A[i]--;
                }
            }

            if(A[0] != 0){
                robot[0] = true;
                A[0]--;
            }

            round++;
        }
        System.out.println(round);

    }
    public static boolean durability(){
        int cnt = 0;

        for(int i: A){
            if(i == 0)
                cnt++;
            if(cnt >= k)
                return false;
        }
        return true;
    }
}
