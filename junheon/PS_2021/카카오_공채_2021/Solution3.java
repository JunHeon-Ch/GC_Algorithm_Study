package PS_2021.카카오_공채_2021;

import java.util.*;

class Solution3 {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> inCar = new HashMap<>();
        Map<String, Integer> outCar = new HashMap<>();
        List<String> numberList = new ArrayList<>();

        for (String record : records) {
            String flag = record.substring(record.lastIndexOf(" ") + 1);
            int idx = record.indexOf(" ");
            String time = record.substring(0, idx);
            String number = record.substring(idx + 1, record.indexOf(" ", idx + 1));
            if (!numberList.contains(number)) {
                numberList.add(number);
            }

            if (flag.equals("IN")) {
                inCar.put(number, time);
            } else {
                int total = 0;
                if (outCar.containsKey(number)) {
                    total += outCar.get(number);
                }

                String inTime = inCar.get(number);
                inCar.remove(number);
                int inHour = Integer.parseInt(inTime.substring(0, inTime.indexOf(":")));
                int inMin = Integer.parseInt(inTime.substring(inTime.indexOf(":") + 1));
                int outHour = Integer.parseInt(time.substring(0, time.indexOf(":")));
                int outMin = Integer.parseInt(time.substring(time.indexOf(":") + 1));
                if (outMin < inMin) {
                    outMin += 60;
                    outHour--;
                }
                total += (outHour - inHour) * 60 + outMin - inMin;
                outCar.put(number, total);
            }
        }

        for (String number : inCar.keySet()) {
            int total = 0;
            if (outCar.containsKey(number)) {
                total += outCar.get(number);
            }

            String inTime = inCar.get(number);
            int inHour = Integer.parseInt(inTime.substring(0, inTime.indexOf(":")));
            int inMin = Integer.parseInt(inTime.substring(inTime.indexOf(":") + 1));
            total += (23 - inHour) * 60 + 59 - inMin;
            outCar.put(number, total);
        }

        Map<String, Integer> totalPrice = new HashMap<>();
        for(String number : outCar.keySet()) {
            int total = outCar.get(number);
            int price = 0;
            if (total <= fees[0]) price += fees[1];
            else {
                price += fees[1] + (int) Math.ceil((double) (total - fees[0]) / fees[2]) * fees[3];
            }
            totalPrice.put(number, price);
        }

        Collections.sort(numberList);
        int[] answer = new int[numberList.size()];
        int i = 0;
        for (String number : numberList) {
            answer[i++] = totalPrice.get(number);
        }
        return answer;
    }
}