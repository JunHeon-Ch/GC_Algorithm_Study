package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class no1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> list = new HashMap<>();
        for(int i=0; i<n; i++){
            String book = br.readLine();
            if(list.containsKey(book)){
                int cnt = list.get(book) + 1;
                list.put(book, cnt);
            }
            else{
                list.put(book, 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(String s: list.keySet()){
            int value = list.get(s);
            max = Math.max(value, max);
        }

        ArrayList<String> books = new ArrayList<>(list.keySet());
        Collections.sort(books);
        for(String a : books){
            if(list.get(a)==max){
                System.out.println(a);
                break;
            }
        }

    }
}
