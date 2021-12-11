package 프로그래머스.lv3.다단계칫솔판매;

import java.util.*;

public class Solution {
    //시간초과 나는 코드
//    public HashMap<String, Integer> list = new HashMap<>();
//    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
//        int[] answer = new int[enroll.length];
//
//        list.put("-", 0);
//        for(int i=0; i<enroll.length; i++){
//            list.put(enroll[i], 0);
//        }
//
//        for(int i=0; i<seller.length; i++){
//            getMoney(seller[i], amount[i] * 100, enroll, referral);
//        }
//
//        for(int i=0; i<enroll.length; i++)
//            answer[i] = list.get(enroll[i]);
//        return answer;
//    }
//    public void getMoney(String start, int money, String[] enroll, String[] referral){
//        int idx = 0;
//        String parent = "";
//        if(start.equals("-")){
//            parent = null;
//        }
//        else{
//            idx = Arrays.asList(enroll).indexOf(start);
//            parent = referral[idx];
//        }
//
//        int myMoney = list.get(start);
//        int parentMoney = money / 10;
//
//        if(parentMoney != 0 && parent != null){
//            myMoney += money - parentMoney;
//            list.put(start, myMoney);
//            getMoney(parent, parentMoney, enroll, referral);
//
//        }else{
//            myMoney += money;
//            list.put(start, myMoney);
//        }
//    }

    HashMap<String, Person> list = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        list.put("-", new Person("-"));
        for(int i = 0; i < enroll.length; i++)
            list.put(enroll[i], new Person(enroll[i]));

        for(int i = 0; i < referral.length; i++)
            list.get(enroll[i]).parent = list.get(referral[i]);

        for(int i=0; i<seller.length; i++){
            getMoney(list.get(seller[i]), amount[i] * 100);
        }

        for(int i=0; i<enroll.length; i++)
            answer[i] = list.get(enroll[i]).profit;
        return answer;
    }
    public void getMoney(Person start, int money){
        int parentMoney = money / 10;

        if(parentMoney != 0 && start.parent != null){
            start.profit += money - parentMoney;
            getMoney(start.parent, parentMoney);

        }else{
            start.profit += money;
        }
    }
}
class Person{
    String name;
    Person parent;
    int profit;
    public Person(String name){
        this.name = name;
        this.parent = null;
        this.profit = 0;
    }
}
