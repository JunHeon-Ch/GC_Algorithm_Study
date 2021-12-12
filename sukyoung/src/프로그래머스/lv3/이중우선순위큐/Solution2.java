package 프로그래머스.lv3.이중우선순위큐;

import java.util.*;

class Solution2 {
    public int[] solution(String[] operations) {

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

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if(list.size() == 0)
            return new int[] {0,0};

        int[] answer = new int[2];
        for(int i=0; i<list.size(); i++){
            min_list.add(list.get(i));
            max_list.add(list.get(i));
        }
        answer[1] = min_list.poll();
        answer[0] = max_list.poll();

        return answer;
    }
}
