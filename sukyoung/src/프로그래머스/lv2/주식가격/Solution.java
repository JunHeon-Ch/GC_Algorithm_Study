package 프로그래머스.lv2.주식가격;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        ArrayList<Integer> priceList = new ArrayList<>();
        for(int price: prices)
            priceList.add(price);

        //System.out.println(priceList.size());
        for(int i=0; i<priceList.size(); i++){
            int cnt = 0;
            boolean flag = true;
            int price = priceList.get(i);
            for(int j=i+1; j<priceList.size(); j++){
                if(price <= priceList.get(j))
                    cnt++;
                else{
                    answer[i] = cnt+1;
                    flag = false;
                    break;
                }
                if(flag)
                    answer[i] = cnt;
            }
        }
        return answer;
    }
}
