package PS_2021.카카오_공채_2021;

import java.util.*;

class Solution1 {
    public int[] solution(String[] id_list, String[] reports, int k) {
        Set<String> report = new HashSet<>();
        for(String r : reports) {
            report.add(r);
        }

        Map<String, Integer> reportMap = new HashMap<>();
        for(String r : report) {
            String name = r.substring(r.indexOf(" ") + 1);
            if(reportMap.containsKey(name)) {
                reportMap.put(name, reportMap.get(name) + 1);
            } else {
                reportMap.put(name, 1);
            }
        }
        List<String> delList = new ArrayList<>();
        for(String name : reportMap.keySet()) {
            if(reportMap.get(name) < k) {
                delList.add(name);
            }
        }
        for(String del : delList) {
            reportMap.remove(del);
        }
        Map<String, Integer> emailMap = new HashMap<>();
        for(String r : report) {
            String name = r.substring(0, r.indexOf(" "));
            String target = r.substring(r.indexOf(" ") + 1);
            if(!reportMap.containsKey(target)) continue;
            if(emailMap.containsKey(name)) {
                emailMap.put(name, emailMap.get(name) + 1);
            } else {
                emailMap.put(name, 1);
            }
        }

        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = 0;
            if(emailMap.containsKey(id_list[i])) {
                answer[i] = emailMap.get(id_list[i]);
            }
        }
        return answer;
    }
}