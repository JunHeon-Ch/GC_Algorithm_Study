package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no10973 {
    public static int N;
    public static int[] currentArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        currentArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            currentArr[i] = Integer.parseInt(st.nextToken());
        }
        if (nextPermutation()){
            for (int value : currentArr) {
                System.out.print(value + " ");
            }
        } else {
            System.out.println(-1);
        }

    }

    public static boolean nextPermutation(){
        int i = currentArr.length-1;
        while(i > 0 && currentArr[i] > currentArr[i-1]) {
            i--;
        }

        if(i == 0) //마지막 순열인 경우
            return false;

        int j = currentArr.length-1;
        while(currentArr[i-1] < currentArr[j]) {
            j--;
        }

        swap(i-1, j);

        j = currentArr.length-1;
        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }

        return true;
    }
    public static void swap(int i, int j) {
        int temp = currentArr[i];
        currentArr[i] = currentArr[j];
        currentArr[j] = temp;
    }
}
