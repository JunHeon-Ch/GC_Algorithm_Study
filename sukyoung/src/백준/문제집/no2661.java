package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2661 {
    public static int[] arr = {1,2,3};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dfs("", n);

    }
    public static void dfs(String str, int size){
        if(str.length() == size){
            System.out.print(str);
            System.exit(0);
        }

        for(int i=0; i<arr.length; i++){
            String temp = str + arr[i];
            if(isAvailable(temp))
                dfs(temp, size);
        }
    }
    public static boolean isAvailable(String str){
        for(int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() -i * 2, str.length() - i);
            String back = str.substring(str.length() - i);
            if(front.equals(back)) return false;
        }
        return true;
    }
}
