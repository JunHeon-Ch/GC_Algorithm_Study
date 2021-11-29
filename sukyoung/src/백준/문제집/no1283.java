package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class no1283 {
    public static Set<String> key = new HashSet<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String str = br.readLine();
            String[] data1 = str.split(" ");
            String[] data2 = str.split("");

            if(getKey1(data1)){
            }else if(getKey2(str, data2)){

            } else {
                sb.append(str + "\n");
            }
        }
        System.out.print(sb);
    }

    public static boolean getKey1(String[] data1){
        for(int i=0; i< data1.length; i++){
            String s = data1[i];
            String t = s.substring(0,1).toUpperCase();
            if(!key.contains(t)){
                key.add(t);
                for(int j=0; j< data1.length; j++){
                    if(j == i){
                        sb.append("[" + s.substring(0, 1) + "]" + s.substring(1) +" ");
                    }else{
                        sb.append(data1[j] + " ");
                    }
                }
                sb.append('\n');
                return true;
            }
        }
        return false;
    }
    public static boolean getKey2(String str, String[] data2){
        for(int i = 0; i < data2.length; i++){
            String s = data2[i].toUpperCase();

            if(s.equals(" ")){
                continue;
            }

            if(!key.contains(s)){
                key.add(s);
                sb.append(str.substring(0,i) + "[" + str.substring(i,i+1) + "]" + str.substring(i+1) + "\n");
                return true;
            }
        }

        return false;
    }
}
