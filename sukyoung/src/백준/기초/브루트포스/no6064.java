package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no6064 {
    static int GCD(int num1, int num2) {
        while(true) {
            if(num2 == 0) break;
            int tmp = num1 % num2;
            num1 = num2;
            num2 = tmp;
        }
        return num1;
    }
    static int LCM(int num1, int num2) {
        return num1 * num2 / GCD(num1, num2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int y_ = x;
            int cnt = x;
            for(int j=0; j< N; j++){
                int temp ;
                if(y_ % N == 0)
                    temp = N;
                else
                    temp = y_ % N;

                if(temp == y)
                    break;
                y_ += M;
                cnt += M;

            }
            if (cnt > LCM(M,N))
                cnt = -1;
            System.out.println(cnt);
        }
    }
}
