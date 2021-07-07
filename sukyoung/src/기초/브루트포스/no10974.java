package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no10974 {
    public static int N;
    public static int[] ans;
    public static int[] currentArr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = new int[N];
        currentArr = new int[N];
        for(int i=0; i<N; i++)
            currentArr[i] = i+1;

        for (int value : currentArr) {
            sb.append(value + " ");
        }
        sb.append('\n');

        nextPermutation(currentArr);
        System.out.print(sb);
    }

    public static boolean nextPermutation(int[] currentArr){
        int i = currentArr.length-1;
        while(i > 0 && currentArr[i] < currentArr[i-1]) {
            i--;
        }

        if(i == 0) //마지막 순열인 경우
            return false;

        int j = currentArr.length-1;
        while(currentArr[i-1] > currentArr[j]) {
            j--;
        }

        swap(i-1, j);

        j = currentArr.length-1;
        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }

        for (int value : currentArr) {
            sb.append(value + " ");
        }
        sb.append('\n');
        nextPermutation(currentArr);

        return true;
    }
    public static void swap(int i, int j) {
        int temp = currentArr[i];
        currentArr[i] = currentArr[j];
        currentArr[j] = temp;
    }
}
