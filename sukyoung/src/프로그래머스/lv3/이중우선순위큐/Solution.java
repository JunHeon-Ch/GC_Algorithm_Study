package 프로그래머스.lv3.이중우선순위큐;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> min_list = new PriorityQueue<>();
        PriorityQueue<Integer> max_list = new PriorityQueue<>(Collections.reverseOrder());
        for(String oper: operations){
            String[] op = oper.split(" ");
            if(op[0].equals("I")){
                list.add(Integer.parseInt(op[1]));
                Collections.sort(list);
            }else{
                if(op[1].equals("1") && list.size() != 0){
                    list.remove(list.size()-1);
                }
                else if(op[1].equals("-1") && list.size() != 0){
                    list.remove(0);
                }
            }
        }
        System.out.println(list);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if(list.size() == 0){
            answer[0] = 0;
            answer[1] = 0;

            return answer;
        }
        for(int i=0; i<list.size(); i++){
            min_list.offer(list.get(i));
            max_list.offer(list.get(i));
        }
        answer[1] = min_list.poll();
        answer[0] = max_list.poll();
        return answer;
    }
}