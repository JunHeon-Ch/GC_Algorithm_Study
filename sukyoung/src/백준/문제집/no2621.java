package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class no2621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> color = new HashMap<>();
        ArrayList<Integer> number = new ArrayList<>();
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            if(color.containsKey(c)){
                int cnt = color.get(c) + 1;
                color.put(c, cnt);
            }
            else{
                color.put(c, 1);
            }
            number.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> score = new ArrayList<>();
        //모든 카드 색이 같음
        if(color.size() == 1){
            ArrayList<Integer> temp = number;
            Collections.sort(temp);

            boolean flag = true;
            for(int i=0; i<4; i++){
                if(temp.get(i+1) - temp.get(i) != 1) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                score.add(900 + temp.get(temp.size()-1));
            else
                score.add(600 + temp.get(temp.size()-1));
        }else{
            HashMap<Integer, Integer> temp = new HashMap<>();
            for(int n: number){
                if(temp.containsKey(n)){
                    int cnt = temp.get(n) + 1;
                    temp.put(n, cnt);
                }else
                    temp.put(n, 1);
            }

            if(temp.size() == 2){
                //4장, 1장
                //3장, 2장
                int cnt = 0;
                int flag = 0;
                for(int key : temp.keySet()){
                    if(temp.get(key) == 4){
                        score.add(800 + key);
                        break;
                    }
                    else if(temp.get(key) == 3 || temp.get(key) == 2){
                        if(temp.get(key) == 3){
                            cnt += 10 * key;
                            flag++;
                        }else{
                            cnt += key + 700;
                            flag++;
                        }
                    }
                }
                if(flag == 2)
                    score.add(cnt);

            }else if(temp.size() == 3){
                //3장, 1장, 1장
                //2장, 2장, 1장
                int idx = 0; boolean flag = false;
                int[] candidate = new int[2];
                for(int key: temp.keySet()){
                    if(temp.get(key) == 3){
                        score.add(key + 400);
                        break;
                    }
                    else if(temp.get(key) == 2){
                        candidate[idx++] = key;
                        flag = true;
                    }
                }
                if(flag){
                    Arrays.sort(candidate);
                    score.add(300 + candidate[0] + candidate[1] * 10);
                }
            }else if(temp.size() == 4){
                //2장, 1장, 1장, 1장
                for(int key: temp.keySet()){
                    if(temp.get(key) == 2)
                        score.add(200 + key);
                }

            }
        }

        Collections.sort(number);
        boolean flag = true;
        for(int i=0; i<4; i++){
            if(number.get(i+1) - number.get(i) != 1) {
                flag = false;
                break;
            }
        }
        if(flag)
            score.add(number.get(number.size()-1) + 500);

        if(score.size() == 0){
            System.out.println(number.get(number.size()-1) + 100);
        }
        else{
            Collections.sort(score);
            System.out.print(score.get(score.size()-1));
        }
    }
}
